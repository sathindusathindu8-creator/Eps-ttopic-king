package com.example.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
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
import com.example.data.ChapterSummary
import com.example.model.Lesson
import com.example.ui.components.CategoryBadge
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGoldAmber
import com.example.ui.theme.KoreanGoldLight
import com.example.ui.theme.KoreanRedAccent
import com.example.ui.theme.KoreanRedLight
import com.example.ui.viewmodel.EpsViewModel
import com.example.ui.viewmodel.MainNavigationTab

@Composable
fun LessonsScreen(
    viewModel: EpsViewModel,
    modifier: Modifier = Modifier
) {
    val currentTab by viewModel.currentTab.collectAsState()
    val initialTabIndex = if (currentTab == MainNavigationTab.BOOK_2) 1 else 0
    var selectedBookIndex by remember(currentTab) { mutableIntStateOf(initialTabIndex) }

    val activeBookNumber = if (selectedBookIndex == 0) 1 else 2
    val loadedLessons = viewModel.repository.getLessonsByBook(activeBookNumber)
    val chaptersForBook = viewModel.repository.chapterDirectory.filter { it.bookNumber == activeBookNumber }

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("lessons_screen_container")
    ) {
        // Book 1 / Book 2 Tab Switcher
        TabRow(
            selectedTabIndex = selectedBookIndex,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = selectedBookIndex == 0,
                onClick = { selectedBookIndex = 0 },
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.MenuBook, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("පොත 1 (පාඩම් 1-30)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }
                },
                modifier = Modifier.testTag("tab_book_1")
            )
            Tab(
                selected = selectedBookIndex == 1,
                onClick = { selectedBookIndex = 1 },
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Book, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("පොත 2 (පාඩම් 31-60)", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    }
                },
                modifier = Modifier.testTag("tab_book_2")
            )
        }

        // Header Description
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (activeBookNumber == 1)
                        "📘 EPS-TOPIK 1 වන පොත: මූලික කොරියානු භාෂාව, එදිනෙදා සංවාද සහ ජීවන රටාව"
                    else
                        "📙 EPS-TOPIK 2 වන පොත: වැඩබිමේ මෙවලම්, යන්ත්‍ර සූත්‍ර, ආරක්ෂාව සහ ශ්‍රම නීති",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 16.sp
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(chaptersForBook) { chapter ->
                val fullLesson = loadedLessons.find { it.id == chapter.chapterNumber }
                ChapterCard(
                    chapter = chapter,
                    fullLesson = fullLesson,
                    onOpenLesson = {
                        if (fullLesson != null) {
                            viewModel.openLesson(fullLesson)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ChapterCard(
    chapter: ChapterSummary,
    fullLesson: Lesson?,
    onOpenLesson: () -> Unit
) {
    val isInteractive = fullLesson != null
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("chapter_card_${chapter.chapterNumber}")
            .clickable(enabled = isInteractive, onClick = onOpenLesson),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isInteractive) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isInteractive) 2.dp else 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Chapter Number badge
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = if (isInteractive) KoreanBluePrimary else Color.LightGray.copy(alpha = 0.6f),
                modifier = Modifier.size(46.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${chapter.chapterNumber}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "과 (පාඩම)",
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 8.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = chapter.titleKorean,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = chapter.titleSinhala,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CategoryBadge(text = chapter.categorySinhala)
                    if (isInteractive) {
                        CategoryBadge(
                            text = "සංවාද සහ හඬ පට",
                            backgroundColor = KoreanGoldLight,
                            contentColor = KoreanGoldAmber
                        )
                    }
                }
            }

            if (isInteractive) {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "පාඩම බලන්න",
                    tint = KoreanBluePrimary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
