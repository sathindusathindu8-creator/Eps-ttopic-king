package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AudioTrackItem
import com.example.data.EpsRepository
import com.example.model.Dialogue
import com.example.model.DialogueLine
import com.example.model.ExamQuestion
import com.example.model.ExamResult
import com.example.model.Lesson
import com.example.model.MockExam
import com.example.model.QuestionType
import com.example.model.Vocabulary
import com.example.tts.KoreanTtsHelper
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class MainNavigationTab {
    HOME,
    BOOK_1,
    BOOK_2,
    AUDIO_TRACKS,  // කොරියන් සංවාද හඬ පට
    EXAM_PAPERS,   // කොරියන් අනුමාන පේපර්
    VOCAB_SEARCH   // වචන කෝෂය
}

data class ExamSessionState(
    val exam: MockExam,
    val currentQuestionIndex: Int = 0,
    val userAnswers: Map<Int, Int> = emptyMap(),
    val flaggedQuestionIds: Set<Int> = emptySet(),
    val remainingSeconds: Int = 50 * 60,
    val isFinished: Boolean = false,
    val result: ExamResult? = null
)

class EpsViewModel(application: Application) : AndroidViewModel(application) {
    val repository = EpsRepository()
    val ttsHelper = KoreanTtsHelper(application)

    private val _currentTab = MutableStateFlow(MainNavigationTab.HOME)
    val currentTab: StateFlow<MainNavigationTab> = _currentTab.asStateFlow()

    private val _selectedLesson = MutableStateFlow<Lesson?>(null)
    val selectedLesson: StateFlow<Lesson?> = _selectedLesson.asStateFlow()

    private val _activeDialoguePlayingId = MutableStateFlow<String?>(null)
    val activeDialoguePlayingId: StateFlow<String?> = _activeDialoguePlayingId.asStateFlow()

    private val _activeDialogueLineIndex = MutableStateFlow<Int?>(null)
    val activeDialogueLineIndex: StateFlow<Int?> = _activeDialogueLineIndex.asStateFlow()

    private val _speechRate = MutableStateFlow(1.0f)
    val speechRate: StateFlow<Float> = _speechRate.asStateFlow()

    // Vocabulary Search & Filter
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedBookFilter = MutableStateFlow(0) // 0: All, 1: Book 1, 2: Book 2
    val selectedBookFilter: StateFlow<Int> = _selectedBookFilter.asStateFlow()

    // CBT Exam Session
    private val _examSession = MutableStateFlow<ExamSessionState?>(null)
    val examSession: StateFlow<ExamSessionState?> = _examSession.asStateFlow()

    private var examTimerJob: Job? = null
    private var dialogueAutoPlayJob: Job? = null

    val isSpeaking = ttsHelper.isSpeaking
    val isKoreanAvailable = ttsHelper.isKoreanAvailable
    val bookmarkedVocabIds = repository.bookmarkedVocabIds

    fun setTab(tab: MainNavigationTab) {
        _currentTab.value = tab
        if (_selectedLesson.value != null && tab != MainNavigationTab.BOOK_1 && tab != MainNavigationTab.BOOK_2) {
            _selectedLesson.value = null
        }
        stopAudio()
    }

    fun openLesson(lesson: Lesson) {
        _selectedLesson.value = lesson
        stopAudio()
    }

    fun closeLesson() {
        _selectedLesson.value = null
        stopAudio()
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setBookFilter(filter: Int) {
        _selectedBookFilter.value = filter
    }

    fun setSpeechRate(rate: Float) {
        _speechRate.value = rate
        ttsHelper.setSpeechRate(rate)
    }

    fun toggleBookmark(vocabId: String) {
        repository.toggleBookmarkVocab(vocabId)
    }

    // Audio Playback
    fun speakWord(wordKorean: String) {
        ttsHelper.stop()
        _activeDialoguePlayingId.value = null
        _activeDialogueLineIndex.value = null
        ttsHelper.speakKorean(wordKorean)
    }

    fun speakSentence(koreanText: String, lineIndex: Int? = null) {
        ttsHelper.stop()
        _activeDialogueLineIndex.value = lineIndex
        ttsHelper.speakKorean(koreanText) {
            _activeDialogueLineIndex.value = null
        }
    }

    fun playFullDialogue(dialogue: Dialogue) {
        stopAudio()
        _activeDialoguePlayingId.value = dialogue.id
        dialogueAutoPlayJob = viewModelScope.launch {
            for (index in dialogue.lines.indices) {
                val line = dialogue.lines[index]
                _activeDialogueLineIndex.value = index
                var lineCompleted = false
                ttsHelper.speakKorean(line.koreanText, "line_${line.id}") {
                    lineCompleted = true
                }
                while (!lineCompleted) {
                    delay(100)
                }
                delay(600) // Pause between speakers naturally
            }
            _activeDialoguePlayingId.value = null
            _activeDialogueLineIndex.value = null
        }
    }

    fun playAudioTrack(track: AudioTrackItem) {
        stopAudio()
        _activeDialoguePlayingId.value = track.id
        ttsHelper.speakKorean(track.textToSpeak, track.id) {
            _activeDialoguePlayingId.value = null
        }
    }

    fun stopAudio() {
        dialogueAutoPlayJob?.cancel()
        dialogueAutoPlayJob = null
        ttsHelper.stop()
        _activeDialoguePlayingId.value = null
        _activeDialogueLineIndex.value = null
    }

    // Exam CBT Simulation
    fun startExam(exam: MockExam) {
        stopAudio()
        _examSession.value = ExamSessionState(
            exam = exam,
            currentQuestionIndex = 0,
            remainingSeconds = exam.totalTimeMinutes * 60
        )
        examTimerJob?.cancel()
        examTimerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                val current = _examSession.value ?: break
                if (current.isFinished) break
                if (current.remainingSeconds <= 1) {
                    finishExam()
                    break
                }
                _examSession.value = current.copy(remainingSeconds = current.remainingSeconds - 1)
            }
        }
    }

    fun playQuestionAudio(question: ExamQuestion) {
        val script = question.audioScriptKorean ?: return
        ttsHelper.stop()
        ttsHelper.speakKorean(script, "exam_q_${question.id}")
    }

    fun selectExamAnswer(questionId: Int, optionIndex: Int) {
        val current = _examSession.value ?: return
        val updatedAnswers = current.userAnswers.toMutableMap()
        updatedAnswers[questionId] = optionIndex
        _examSession.value = current.copy(userAnswers = updatedAnswers)
    }

    fun toggleFlagQuestion(questionId: Int) {
        val current = _examSession.value ?: return
        val flagged = current.flaggedQuestionIds.toMutableSet()
        if (flagged.contains(questionId)) {
            flagged.remove(questionId)
        } else {
            flagged.add(questionId)
        }
        _examSession.value = current.copy(flaggedQuestionIds = flagged)
    }

    fun goToExamQuestion(index: Int) {
        val current = _examSession.value ?: return
        if (index in current.exam.questions.indices) {
            _examSession.value = current.copy(currentQuestionIndex = index)
            stopAudio()
        }
    }

    fun finishExam() {
        val current = _examSession.value ?: return
        examTimerJob?.cancel()
        stopAudio()

        val exam = current.exam
        var readingScore = 0
        var listeningScore = 0
        var correctCount = 0

        exam.questions.forEach { q ->
            val userAns = current.userAnswers[q.id]
            if (userAns == q.correctOptionIndex) {
                correctCount++
                if (q.type == QuestionType.READING) {
                    readingScore += q.points
                } else {
                    listeningScore += q.points
                }
            }
        }
        val totalScore = readingScore + listeningScore
        val passed = totalScore >= exam.passMarks

        val result = ExamResult(
            examId = exam.id,
            paperTitleSinhala = exam.titleSinhala,
            score = totalScore,
            maxScore = exam.totalMarks,
            readingScore = readingScore,
            listeningScore = listeningScore,
            correctAnswersCount = correctCount,
            totalQuestionsCount = exam.questions.size,
            passed = passed,
            userAnswers = current.userAnswers
        )

        repository.saveExamResult(result)
        _examSession.value = current.copy(isFinished = true, result = result)
    }

    fun exitExam() {
        examTimerJob?.cancel()
        stopAudio()
        _examSession.value = null
    }

    override fun onCleared() {
        super.onCleared()
        stopAudio()
        ttsHelper.shutdown()
    }
}
