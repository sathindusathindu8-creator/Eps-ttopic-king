package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.OutlinedFlag
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ExamQuestion
import com.example.model.ExamResult
import com.example.model.MockExam
import com.example.model.QuestionType
import com.example.ui.components.CategoryBadge
import com.example.ui.theme.KoreanBlueDark
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGoldAmber
import com.example.ui.theme.KoreanGoldLight
import com.example.ui.theme.KoreanRedAccent
import com.example.ui.theme.KoreanRedLight
import com.example.ui.viewmodel.EpsViewModel
import com.example.ui.viewmodel.ExamSessionState

@Composable
fun ExamSimulatorScreen(
    viewModel: EpsViewModel,
    modifier: Modifier = Modifier
) {
    val examSession by viewModel.examSession.collectAsState()
    val pastResults by viewModel.repository.pastExamResults.collectAsState()

    if (examSession == null) {
        ExamSelectionView(
            modelPapers = viewModel.repository.modelExamPapers,
            pastResults = pastResults,
            onStartExam = { viewModel.startExam(it) },
            modifier = modifier
        )
    } else {
        val session = examSession!!
        if (session.isFinished && session.result != null) {
            ExamResultReviewView(
                session = session,
                onExit = { viewModel.exitExam() },
                modifier = modifier
            )
        } else {
            ActiveCbtExamView(
                session = session,
                onSelectAnswer = { qId, optIdx -> viewModel.selectExamAnswer(qId, optIdx) },
                onToggleFlag = { viewModel.toggleFlagQuestion(it) },
                onNextQuestion = { viewModel.goToExamQuestion(session.currentQuestionIndex + 1) },
                onPrevQuestion = { viewModel.goToExamQuestion(session.currentQuestionIndex - 1) },
                onJumpQuestion = { viewModel.goToExamQuestion(it) },
                onPlayAudio = { viewModel.playQuestionAudio(it) },
                onSubmitExam = { viewModel.finishExam() },
                onExitExam = { viewModel.exitExam() },
                modifier = modifier
            )
        }
    }
}

@Composable
fun ExamSelectionView(
    modelPapers: List<MockExam>,
    pastResults: List<ExamResult>,
    onStartExam: (MockExam) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("exam_selection_view"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = KoreanBluePrimary)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White.copy(alpha = 0.2f),
                            modifier = Modifier.size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Filled.Assignment, contentDescription = null, tint = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "EPS-TOPIK CBT අනුමාන පේපර්",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                            Text(
                                text = "Computer-Based Test Simulator",
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.85f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "කොරියානු HRD ආයතනයේ නිල EPS-TOPIK විභාග ආකෘතියට අනුව කියවීම (읽기) සහ සවන්දීම (듣기) ප්‍රශ්න සහිතව කාල ගණකයක් (Timer), හඬ පට සහ සිංහල විවරණ මෙහි අන්තර්ගතයි.",
                        fontSize = 12.sp,
                        lineHeight = 17.sp,
                        color = Color.White.copy(alpha = 0.95f)
                    )
                }
            }
        }

        item {
            Text(
                text = "ලබා ගත හැකි අනුමාන ප්‍රශ්න පත්‍ර",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        items(modelPapers) { paper ->
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = paper.titleKorean,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = KoreanBluePrimary
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = paper.titleSinhala,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = paper.descriptionSinhala,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CategoryBadge(text = "කාලය: මිනිත්තු ${paper.totalTimeMinutes}")
                        CategoryBadge(text = "ප්‍රශ්න: ${paper.questions.size}")
                        CategoryBadge(text = "ලකුණු: ${paper.totalMarks}", backgroundColor = KoreanGoldLight, contentColor = KoreanGoldAmber)
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    Button(
                        onClick = { onStartExam(paper) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("start_exam_button_${paper.id}"),
                        colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Filled.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("විභාගය අරඹන්න (Start CBT)", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        if (pastResults.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "පසුගිය විභාග ලකුණු සටහන (Past Attempts)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            items(pastResults) { result ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = result.paperTitleSinhala,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "කියවීම: ${result.readingScore} | සවන්දීම: ${result.listeningScore} (නිවැරදි පිළිතුරු: ${result.correctAnswersCount}/${result.totalQuestionsCount})",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (result.passed) Color(0xFFE8F5E9) else KoreanRedLight
                        ) {
                            Text(
                                text = "${result.score}/${result.maxScore}\n${if (result.passed) "සමත් (PASS)" else "අසමත්"}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (result.passed) Color(0xFF2E7D32) else KoreanRedAccent,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActiveCbtExamView(
    session: ExamSessionState,
    onSelectAnswer: (Int, Int) -> Unit,
    onToggleFlag: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onPrevQuestion: () -> Unit,
    onJumpQuestion: (Int) -> Unit,
    onPlayAudio: (ExamQuestion) -> Unit,
    onSubmitExam: () -> Unit,
    onExitExam: () -> Unit,
    modifier: Modifier = Modifier
) {
    val exam = session.exam
    val currentQuestion = exam.questions.getOrNull(session.currentQuestionIndex) ?: return
    val selectedOptionIndex = session.userAnswers[currentQuestion.id]
    val isFlagged = session.flaggedQuestionIds.contains(currentQuestion.id)

    var showSubmitConfirmation by remember { mutableStateOf(false) }
    var showExitConfirmation by remember { mutableStateOf(false) }

    val minutes = session.remainingSeconds / 60
    val seconds = session.remainingSeconds % 60
    val timerString = String.format("%02d:%02d", minutes, seconds)
    val isTimeRunningOut = session.remainingSeconds < 300 // < 5 mins

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "ප්‍රශ්නය ${session.currentQuestionIndex + 1} / ${exam.questions.size}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        // Timer Badge
                        Surface(
                            shape = RoundedCornerShape(14.dp),
                            color = if (isTimeRunningOut) KoreanRedAccent else KoreanBlueDark
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Filled.Timer, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = timerString,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { showExitConfirmation = true }) {
                        Icon(Icons.Filled.Close, contentDescription = "ඉවත් වන්න")
                    }
                },
                actions = {
                    IconButton(onClick = { onToggleFlag(currentQuestion.id) }) {
                        Icon(
                            imageVector = if (isFlagged) Icons.Filled.Flag else Icons.Filled.OutlinedFlag,
                            contentDescription = "Flag for review",
                            tint = if (isFlagged) KoreanGoldAmber else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        modifier = modifier.testTag("active_cbt_exam_view")
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Question Palette Horizontal Selector
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                itemsIndexed(exam.questions) { index, q ->
                    val isCurrent = index == session.currentQuestionIndex
                    val isAnswered = session.userAnswers.containsKey(q.id)
                    val isQFlagged = session.flaggedQuestionIds.contains(q.id)

                    val bgColor = when {
                        isCurrent -> KoreanBluePrimary
                        isQFlagged -> KoreanGoldAmber
                        isAnswered -> Color(0xFF2E7D32)
                        else -> MaterialTheme.colorScheme.surface
                    }

                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(bgColor)
                            .clickable { onJumpQuestion(index) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${index + 1}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isCurrent || isQFlagged || isAnswered) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Question Body
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Section Badge: 읽기 (Reading) vs 듣기 (Listening)
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CategoryBadge(
                            text = if (currentQuestion.type == QuestionType.READING) "읽기 (කියවීම)" else "듣기 (සවන්දීම - Audio)",
                            backgroundColor = if (currentQuestion.type == QuestionType.READING) KoreanBlueLight else KoreanGoldLight,
                            contentColor = if (currentQuestion.type == QuestionType.READING) KoreanBluePrimary else KoreanGoldAmber
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${currentQuestion.points} ලකුණු",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Instructions
                item {
                    Text(
                        text = currentQuestion.instructionKorean,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = currentQuestion.instructionSinhala,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Audio Button for Listening Questions!
                if (currentQuestion.type == QuestionType.LISTENING) {
                    item {
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = KoreanBlueLight)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Filled.Headphones, contentDescription = null, tint = KoreanBluePrimary)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column {
                                        Text(text = "කොරියානු හඬ පටය", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = KoreanBlueDark)
                                        Text(text = "හඬ පටය අසා පිළිතුර තෝරන්න", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                    }
                                }

                                Button(
                                    onClick = { onPlayAudio(currentQuestion) },
                                    colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier.testTag("play_question_audio_${currentQuestion.id}")
                                ) {
                                    Icon(Icons.Filled.VolumeUp, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("අසන්න", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }

                // Graphic Symbol or Passage
                if (currentQuestion.graphicSymbolEmoji != null || currentQuestion.passageKorean != null) {
                    item {
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                if (currentQuestion.graphicSymbolEmoji != null) {
                                    Text(
                                        text = currentQuestion.graphicSymbolEmoji,
                                        fontSize = 40.sp,
                                        modifier = Modifier.padding(bottom = 6.dp)
                                    )
                                }
                                if (currentQuestion.passageKorean != null) {
                                    Text(
                                        text = currentQuestion.passageKorean,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        lineHeight = 20.sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }
                }

                // 4 Choices (Radio Buttons)
                item {
                    Text(
                        text = "පිළිතුර තෝරන්න (Select Answer):",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                itemsIndexed(currentQuestion.options) { optIdx, optionText ->
                    val isSelected = selectedOptionIndex == optIdx
                    Surface(
                        onClick = { onSelectAnswer(currentQuestion.id, optIdx) },
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) KoreanBlueLight else MaterialTheme.colorScheme.surface,
                        border = androidx.compose.foundation.BorderStroke(
                            width = if (isSelected) 1.5.dp else 1.dp,
                            color = if (isSelected) KoreanBluePrimary else MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("exam_option_${optIdx}")
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = isSelected,
                                onClick = { onSelectAnswer(currentQuestion.id, optIdx) },
                                colors = RadioButtonDefaults.colors(selectedColor = KoreanBluePrimary)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = optionText,
                                fontSize = 13.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            // Bottom Navigation Actions
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 6.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = onPrevQuestion,
                        enabled = session.currentQuestionIndex > 0,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("පෙර", fontSize = 12.sp)
                    }

                    Button(
                        onClick = { showSubmitConfirmation = true },
                        colors = ButtonDefaults.buttonColors(containerColor = KoreanRedAccent),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.testTag("submit_exam_button")
                    ) {
                        Text("විභාගය අවසන් කරන්න", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = onNextQuestion,
                        enabled = session.currentQuestionIndex < exam.questions.size - 1,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary)
                    ) {
                        Text("මීළඟ", fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
                    }
                }
            }
        }
    }

    if (showSubmitConfirmation) {
        AlertDialog(
            onDismissRequest = { showSubmitConfirmation = false },
            title = { Text("විභාගය අවසන් කිරීමට අවශ්‍යද?", fontWeight = FontWeight.Bold) },
            text = {
                val answeredCount = session.userAnswers.size
                val totalCount = exam.questions.size
                Text("ඔබ ප්‍රශ්න $totalCount කින් $answeredCount කට පිළිතුරු සපයා ඇත. ඔබට ලකුණු සහ විවරණ බැලීමට අවශ්‍යද?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showSubmitConfirmation = false
                        onSubmitExam()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary)
                ) {
                    Text("ඔව්, අවසන් කරන්න")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showSubmitConfirmation = false }) {
                    Text("තවදුරටත් පිළිතුරු දෙන්න")
                }
            }
        )
    }

    if (showExitConfirmation) {
        AlertDialog(
            onDismissRequest = { showExitConfirmation = false },
            title = { Text("විභාගයෙන් ඉවත් වීමට අවශ්‍යද?") },
            text = { Text("දැන් ඉවත් වුවහොත් මෙම විභාගයේ ප්‍රගතිය අහිමි වනු ඇත.") },
            confirmButton = {
                Button(
                    onClick = {
                        showExitConfirmation = false
                        onExitExam()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KoreanRedAccent)
                ) {
                    Text("ඉවත් වන්න")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showExitConfirmation = false }) {
                    Text("නැත")
                }
            }
        )
    }
}

@Composable
fun ExamResultReviewView(
    session: ExamSessionState,
    onExit: () -> Unit,
    modifier: Modifier = Modifier
) {
    val result = session.result ?: return
    val exam = session.exam

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("exam_result_review_view"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Result Score Summary Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (result.passed) Color(0xFFE8F5E9) else KoreanRedLight
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = if (result.passed) Icons.Filled.CheckCircle else Icons.Filled.Close,
                        contentDescription = null,
                        tint = if (result.passed) Color(0xFF2E7D32) else KoreanRedAccent,
                        modifier = Modifier.size(54.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = if (result.passed) "විභාගය සාර්ථකව සමත් විය! (PASSED)" else "අසමත් විය (FAIL)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = if (result.passed) Color(0xFF2E7D32) else KoreanRedAccent
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "සම්පූර්ණ ලකුණු: ${result.score} / ${result.maxScore}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "සමත් වීමට අවශ්‍ය අවම ලකුණු: ${exam.passMarks}",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ScoreStatChip(label = "කියවීම (읽기)", score = "${result.readingScore} ලකුණු")
                        ScoreStatChip(label = "සවන්දීම (듣기)", score = "${result.listeningScore} ලකුණු")
                        ScoreStatChip(label = "නිවැරදි පිළිතුරු", score = "${result.correctAnswersCount}/${result.totalQuestionsCount}")
                    }
                }
            }
        }

        item {
            Button(
                onClick = onExit,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = KoreanBluePrimary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("විභාග ලැයිස්තුවට ආපසු යන්න", fontWeight = FontWeight.Bold)
            }
        }

        // Detailed Question-by-question Review with Sinhala Explanations
        item {
            Text(
                text = "ප්‍රශ්න විවරණ සහ නිවැරදි පිළිතුරු (Detailed Review)",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        itemsIndexed(exam.questions) { index, q ->
            val userOptionIdx = session.userAnswers[q.id]
            val isCorrect = userOptionIdx == q.correctOptionIndex

            Card(
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    if (isCorrect) Color(0xFF81C784) else KoreanRedLight
                )
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "ප්‍රශ්නය ${index + 1} (${if (q.type == QuestionType.READING) "읽기" else "듣기"})",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                            color = KoreanBluePrimary
                        )

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (isCorrect) Color(0xFFE8F5E9) else KoreanRedLight
                        ) {
                            Text(
                                text = if (isCorrect) "✓ නිවැරදියි (+${q.points})" else "✗ වැරදියි (0)",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isCorrect) Color(0xFF2E7D32) else KoreanRedAccent,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = q.instructionKorean,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (q.passageKorean != null) {
                        Text(
                            text = q.passageKorean,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "ඔබේ පිළිතුර: ${if (userOptionIdx != null) q.options[userOptionIdx] else "පිළිතුරු සපයා නැත"}",
                        fontSize = 12.sp,
                        color = if (isCorrect) Color(0xFF2E7D32) else KoreanRedAccent,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (!isCorrect) {
                        Text(
                            text = "නිවැරදි පිළිතුර: ${q.options[q.correctOptionIndex]}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = KoreanBlueLight,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "💡 සිංහල විවරණය (Explanation):",
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                                color = KoreanBlueDark
                            )
                            Text(
                                text = q.explanationSinhala,
                                fontSize = 11.sp,
                                lineHeight = 16.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScoreStatChip(label: String, score: String) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.White.copy(alpha = 0.8f)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(text = score, fontWeight = FontWeight.Bold, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}
