package com.example.data

import com.example.model.Dialogue
import com.example.model.ExamResult
import com.example.model.GrammarPoint
import com.example.model.Lesson
import com.example.model.MockExam
import com.example.model.Vocabulary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AudioTrackItem(
    val id: String,
    val titleKorean: String,
    val titleSinhala: String,
    val speakerOrCategory: String,
    val textToSpeak: String,
    val lessonId: Int,
    val bookId: Int
)

class EpsRepository {
    private val _book1Lessons = EpsBook1Data.lessons
    private val _book2Lessons = EpsBook2Data.lessons
    val allLoadedLessons: List<Lesson> = _book1Lessons + _book2Lessons

    val chapterDirectory = EpsChapterDirectory.allChapters
    val modelExamPapers: List<MockExam> = EpsExamPapersData.modelPapers

    private val _bookmarkedVocabIds = MutableStateFlow<Set<String>>(emptySet())
    val bookmarkedVocabIds: StateFlow<Set<String>> = _bookmarkedVocabIds.asStateFlow()

    private val _pastExamResults = MutableStateFlow<List<ExamResult>>(emptyList())
    val pastExamResults: StateFlow<List<ExamResult>> = _pastExamResults.asStateFlow()

    fun getLessonById(lessonId: Int): Lesson? {
        return allLoadedLessons.find { it.id == lessonId }
    }

    fun getLessonsByBook(bookId: Int): List<Lesson> {
        return allLoadedLessons.filter { it.bookId == bookId }
    }

    fun getAllVocabularies(): List<Vocabulary> {
        return allLoadedLessons.flatMap { it.vocabularies }
    }

    fun getAllGrammarPoints(): List<GrammarPoint> {
        return allLoadedLessons.flatMap { it.grammars }
    }

    fun searchVocabularies(query: String): List<Vocabulary> {
        if (query.isBlank()) return getAllVocabularies()
        val cleanQuery = query.trim().lowercase()
        return getAllVocabularies().filter {
            it.korean.lowercase().contains(cleanQuery) ||
            it.sinhalaMeaning.lowercase().contains(cleanQuery) ||
            it.sinhalaPronunciation.lowercase().contains(cleanQuery) ||
            it.englishMeaning.lowercase().contains(cleanQuery) ||
            it.category.lowercase().contains(cleanQuery)
        }
    }

    fun toggleBookmarkVocab(vocabId: String) {
        val current = _bookmarkedVocabIds.value.toMutableSet()
        if (current.contains(vocabId)) {
            current.remove(vocabId)
        } else {
            current.add(vocabId)
        }
        _bookmarkedVocabIds.value = current
    }

    fun saveExamResult(result: ExamResult) {
        _pastExamResults.value = listOf(result) + _pastExamResults.value
    }

    fun getAllAudioTracks(): List<AudioTrackItem> {
        val tracks = mutableListOf<AudioTrackItem>()
        allLoadedLessons.forEach { lesson ->
            lesson.dialogues.forEach { dialogue ->
                val fullConversationScript = dialogue.lines.joinToString(" ") { it.koreanText }
                tracks.add(
                    AudioTrackItem(
                        id = dialogue.id,
                        titleKorean = "${lesson.koreanTitle} - ${dialogue.titleKorean}",
                        titleSinhala = "${lesson.sinhalaTitle} - ${dialogue.titleSinhala}",
                        speakerOrCategory = "සංවාද හඬ පටය (Dialogue Audio)",
                        textToSpeak = fullConversationScript,
                        lessonId = lesson.id,
                        bookId = lesson.bookId
                    )
                )
            }
        }
        return tracks
    }
}
