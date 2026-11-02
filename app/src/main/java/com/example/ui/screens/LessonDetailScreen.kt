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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.model.Dialogue
import com.example.model.DialogueLine
import com.example.model.GrammarPoint
import com.example.model.Lesson
import com.example.model.Vocabulary
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.components.CategoryBadge
import com.example.ui.components.SpeedSelector
import com.example.ui.theme.KoreanBlueDark
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGoldAmber
import com.example.ui.theme.KoreanGoldLight
import com.example.ui.theme.KoreanRedAccent
import com.example.ui.theme.KoreanRedLight
import com.example.ui.viewmodel.EpsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    viewModel: EpsViewModel,
    modifier: Modifier = Modifier
) {
    var selectedSectionIndex by remember { mutableIntStateOf(0) }
    val speechRate by viewModel.speechRate.collectAsState()
    val activePlayingId by viewModel.activeDialoguePlayingId.collectAsState()
    val activeSpokenLineIndex by viewModel.activeDialogueLineIndex.collectAsState()
    val isSpeaking by viewModel.isSpeaking.collectAsState()
    val bookmarkedVocabIds by viewModel.bookmarkedVocabIds.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = lesson.koreanTitle,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                        Text(
                            text = lesson.sinhalaTitle,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.closeLesson() },
                        modifier = Modifier.testTag("lesson_back_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "ආපසු")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = modifier.testTag("lesson_detail_screen")
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Speed Controls Bar
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SpeedSelector(
                        currentSpeed = speechRate,
                        onSpeedSelected = { viewModel.setSpeechRate(it) }
                    )
                    if (isSpeaking) {
                        Surface(
                            onClick = { viewModel.stopAudio() },
                            shape = RoundedCornerShape(12.dp),
                            color = KoreanRedAccent
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Filled.Stop, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("නවතන්න", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            // Section Tabs: සංවාද | වචන | ව්‍යාකරණ | සංස්කෘතිය
            TabRow(
                selectedTabIndex = selectedSectionIndex,
                modifier = Modifier.fillMaxWidth()
            ) {
                Tab(
                    selected = selectedSectionIndex == 0,
                    onClick = { selectedSectionIndex = 0 },
                    text = { Text("සංවාද", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Filled.ChatBubble, contentDescription = null, modifier = Modifier.size(16.dp)) },
                    modifier = Modifier.testTag("tab_dialogues")
                )
                Tab(
                    selected = selectedSectionIndex == 1,
                    onClick = { selectedSectionIndex = 1 },
                    text = { Text("වචන", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Filled.Translate, contentDescription = null, modifier = Modifier.size(16.dp)) },
                    modifier = Modifier.testTag("tab_vocab")
                )
                Tab(
                    selected = selectedSectionIndex == 2,
                    onClick = { selectedSectionIndex = 2 },
                    text = { Text("ව්‍යාකරණ", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Filled.School, contentDescription = null, modifier = Modifier.size(16.dp)) },
                    modifier = Modifier.testTag("tab_grammar")
                )
                Tab(
                    selected = selectedSectionIndex == 3,
                    onClick = { selectedSectionIndex = 3 },
                    text = { Text("තොරතුරු", fontSize = 11.sp, fontWeight = FontWeight.Bold) },
                    icon = { Icon(Icons.Filled.Info, contentDescription = null, modifier = Modifier.size(16.dp)) },
                    modifier = Modifier.testTag("tab_culture")
                )
            }

            Box(modifier = Modifier.fillMaxSize()) {
                when (selectedSectionIndex) {
                    0 -> DialoguesContent(
                        dialogues = lesson.dialogues,
                        activePlayingId = activePlayingId,
                        activeSpokenLineIndex = activeSpokenLineIndex,
                        onPlayFullDialogue = { viewModel.playFullDialogue(it) },
                        onStopAudio = { viewModel.stopAudio() },
                        onPlayLine = { text, idx -> viewModel.speakSentence(text, idx) }
                    )
                    1 -> VocabulariesContent(
                        vocabularies = lesson.vocabularies,
                        bookmarkedIds = bookmarkedVocabIds,
                        onPlayAudio = { viewModel.speakWord(it) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) }
                    )
                    2 -> GrammarsContent(
                        grammars = lesson.grammars,
                        onPlayAudio = { viewModel.speakSentence(it) }
                    )
                    3 -> CultureContent(
                        culturalNote = lesson.culturalNoteSinhala,
                        titleSinhala = lesson.cultureTitleSinhala,
                        titleKorean = lesson.cultureTitleKorean
                    )
                }
            }
        }
    }
}

@Composable
fun DialoguesContent(
    dialogues: List<Dialogue>,
    activePlayingId: String?,
    activeSpokenLineIndex: Int?,
    onPlayFullDialogue: (Dialogue) -> Unit,
    onStopAudio: () -> Unit,
    onPlayLine: (String, Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(dialogues) { dialogue ->
            val isDialoguePlaying = activePlayingId == dialogue.id
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    // Header of Dialogue with Play Full Conversation Button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = dialogue.titleKorean,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = KoreanBluePrimary
                            )
                            Text(
                                text = dialogue.titleSinhala,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            if (dialogue.contextNoteSinhala.isNotBlank()) {
                                Text(
                                    text = "💡 ${dialogue.contextNoteSinhala}",
                                    fontSize = 11.sp,
                                    color = KoreanGoldAmber
                                )
                            }
                        }

                        Button(
                            onClick = {
                                if (isDialoguePlaying) onStopAudio() else onPlayFullDialogue(dialogue)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isDialoguePlaying) KoreanRedAccent else KoreanBluePrimary
                            ),
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                            modifier = Modifier.testTag("play_full_dialogue_${dialogue.id}")
                        ) {
                            Icon(
                                imageVector = if (isDialoguePlaying) Icons.Filled.Stop else Icons.Filled.PlayArrow,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isDialoguePlaying) "නවත්වන්න" else "හඬ පටය",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Dialogue Lines
                    dialogue.lines.forEachIndexed { index, line ->
                        val isLineActive = isDialoguePlaying && activeSpokenLineIndex == index
                        DialogueLineItem(
                            line = line,
                            isHighlighted = isLineActive,
                            onPlayLine = { onPlayLine(line.koreanText, index) }
                        )
                        if (index < dialogue.lines.size - 1) {
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DialogueLineItem(
    line: DialogueLine,
    isHighlighted: Boolean,
    onPlayLine: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = if (isHighlighted) KoreanBlueLight else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
        border = if (isHighlighted) androidx.compose.foundation.BorderStroke(1.5.dp, KoreanBluePrimary) else null,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = line.speaker,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = KoreanBluePrimary
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = line.koreanText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "[${line.pronunciationSinhala}]",
                    fontSize = 11.sp,
                    color = KoreanRedAccent
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = line.sinhalaText,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            AudioSpeakerButton(
                onClick = onPlayLine,
                isPlaying = isHighlighted,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun VocabulariesContent(
    vocabularies: List<Vocabulary>,
    bookmarkedIds: Set<String>,
    onPlayAudio: (String) -> Unit,
    onToggleBookmark: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                text = "මෙම පාඩමේ අත්‍යවශ්‍ය වචන මාලාව (${vocabularies.size})",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        items(vocabularies) { vocab ->
            val isBookmarked = bookmarkedIds.contains(vocab.id)
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = vocab.korean,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "[${vocab.sinhalaPronunciation}]",
                                fontSize = 12.sp,
                                color = KoreanRedAccent
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = vocab.sinhalaMeaning,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                            color = KoreanBluePrimary
                        )
                        Text(
                            text = "${vocab.englishMeaning} • කාණ්ඩය: ${vocab.category}",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = { onToggleBookmark(vocab.id) },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                                contentDescription = "Bookmark",
                                tint = if (isBookmarked) KoreanGoldAmber else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        AudioSpeakerButton(
                            onClick = { onPlayAudio(vocab.korean) },
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GrammarsContent(
    grammars: List<GrammarPoint>,
    onPlayAudio: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(grammars) { grammar ->
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = KoreanBlueLight,
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(
                            text = grammar.patternKorean,
                            color = KoreanBlueDark,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }

                    Text(
                        text = grammar.titleSinhala,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = grammar.ruleExplanationSinhala,
                        fontSize = 13.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "භාවිතා වන ආකාරය (Rule):",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                color = KoreanRedAccent
                            )
                            Text(
                                text = grammar.usageCondition,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "උදාහරණ වාක්‍ය (Examples):",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    grammar.examples.forEach { example ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = example.korean,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = example.sinhala,
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                AudioSpeakerButton(
                                    onClick = { onPlayAudio(example.korean) },
                                    modifier = Modifier.size(36.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CultureContent(
    culturalNote: String,
    titleSinhala: String,
    titleKorean: String
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = KoreanGoldLight,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Filled.Info, contentDescription = null, tint = KoreanGoldAmber)
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = titleKorean,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = KoreanGoldAmber
                            )
                            Text(
                                text = titleSinhala,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = culturalNote,
                        fontSize = 13.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
