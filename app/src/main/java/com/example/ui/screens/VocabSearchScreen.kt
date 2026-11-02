package com.example.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.Vocabulary
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.components.CategoryBadge
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGoldAmber
import com.example.ui.theme.KoreanRedAccent
import com.example.ui.viewmodel.EpsViewModel

@Composable
fun VocabSearchScreen(
    viewModel: EpsViewModel,
    modifier: Modifier = Modifier
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val bookFilter by viewModel.selectedBookFilter.collectAsState()
    val bookmarkedIds by viewModel.bookmarkedVocabIds.collectAsState()

    val rawFiltered = viewModel.repository.searchVocabularies(searchQuery)
    val finalVocabList = when (bookFilter) {
        1 -> rawFiltered.filter { it.bookId == 1 }
        2 -> rawFiltered.filter { it.bookId == 2 }
        3 -> rawFiltered.filter { bookmarkedIds.contains(it.id) }
        else -> rawFiltered
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("vocab_search_screen")
    ) {
        // Search TextField
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.setSearchQuery(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .testTag("vocab_search_text_field"),
            placeholder = { Text("වචනයක් සොයන්න (උදා: ප්ලයර්, 펜치, ආයතනය, doctor...)") },
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = null, tint = KoreanBluePrimary)
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { viewModel.setSearchQuery("") }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(14.dp)
        )

        // Filter Chips Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            FilterChip(
                selected = bookFilter == 0,
                onClick = { viewModel.setBookFilter(0) },
                label = { Text("සියල්ල (${rawFiltered.size})", fontSize = 11.sp) }
            )
            FilterChip(
                selected = bookFilter == 1,
                onClick = { viewModel.setBookFilter(1) },
                label = { Text("පොත 1", fontSize = 11.sp) }
            )
            FilterChip(
                selected = bookFilter == 2,
                onClick = { viewModel.setBookFilter(2) },
                label = { Text("පොත 2", fontSize = 11.sp) }
            )
            FilterChip(
                selected = bookFilter == 3,
                onClick = { viewModel.setBookFilter(3) },
                label = { Text("තරු කළ (${bookmarkedIds.size})", fontSize = 11.sp) }
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        if (finalVocabList.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "වචන හමු නොවීය",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "වෙනත් වචනයක් යොදා සොයා බලන්න.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(finalVocabList) { vocab ->
                    val isBookmarked = bookmarkedIds.contains(vocab.id)
                    VocabCard(
                        vocab = vocab,
                        isBookmarked = isBookmarked,
                        onPlayAudio = { viewModel.speakWord(vocab.korean) },
                        onToggleBookmark = { viewModel.toggleBookmark(vocab.id) },
                        onOpenLesson = {
                            val lesson = viewModel.repository.getLessonById(vocab.lessonId)
                            if (lesson != null) viewModel.openLesson(lesson)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun VocabCard(
    vocab: Vocabulary,
    isBookmarked: Boolean,
    onPlayAudio: () -> Unit,
    onToggleBookmark: () -> Unit,
    onOpenLesson: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
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
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "[${vocab.sinhalaPronunciation}]",
                        fontSize = 12.sp,
                        color = KoreanRedAccent
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = vocab.sinhalaMeaning,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = KoreanBluePrimary
                )
                Text(
                    text = "${vocab.englishMeaning} • ${vocab.category}",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "පාඩම ${vocab.lessonId} (පොත ${vocab.bookId}) වෙත යන්න →",
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.clickable(onClick = onOpenLesson)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = onToggleBookmark,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                        contentDescription = "Bookmark",
                        tint = if (isBookmarked) KoreanGoldAmber else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                AudioSpeakerButton(
                    onClick = onPlayAudio,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}
