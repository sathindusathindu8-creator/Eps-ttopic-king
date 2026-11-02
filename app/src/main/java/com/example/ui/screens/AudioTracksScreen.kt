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
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.example.data.AudioTrackItem
import com.example.ui.components.CategoryBadge
import com.example.ui.components.SpeedSelector
import com.example.ui.theme.KoreanBlueDark
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGoldAmber
import com.example.ui.theme.KoreanGoldLight
import com.example.ui.theme.KoreanRedAccent
import com.example.ui.viewmodel.EpsViewModel

@Composable
fun AudioTracksScreen(
    viewModel: EpsViewModel,
    modifier: Modifier = Modifier
) {
    var selectedFilter by remember { mutableIntStateOf(0) } // 0: All, 1: Book 1, 2: Book 2
    val allTracks = viewModel.repository.getAllAudioTracks()
    val filteredTracks = when (selectedFilter) {
        1 -> allTracks.filter { it.bookId == 1 }
        2 -> allTracks.filter { it.bookId == 2 }
        else -> allTracks
    }

    val activePlayingId by viewModel.activeDialoguePlayingId.collectAsState()
    val speechRate by viewModel.speechRate.collectAsState()
    val isSpeaking by viewModel.isSpeaking.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("audio_tracks_screen")
    ) {
        // Audio Player Controls Header
        Surface(
            color = KoreanBlueLight,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = KoreanBluePrimary,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = if (isSpeaking) Icons.Filled.Equalizer else Icons.Filled.Headphones,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "කොරියානු සංවාද හඬ පට (Audio)",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = KoreanBlueDark
                            )
                            Text(
                                text = if (isSpeaking) "හඬ පටය ක්‍රියාත්මකයි..." else "සංවාදවලට සවන් දී පුහුණු වන්න",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    if (isSpeaking) {
                        Button(
                            onClick = { viewModel.stopAudio() },
                            colors = ButtonDefaults.buttonColors(containerColor = KoreanRedAccent),
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                            modifier = Modifier.height(32.dp)
                        ) {
                            Icon(Icons.Filled.Stop, contentDescription = null, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("නවත්වන්න", fontSize = 11.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                SpeedSelector(
                    currentSpeed = speechRate,
                    onSpeedSelected = { viewModel.setSpeechRate(it) }
                )
            }
        }

        // Filter Chips Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedFilter == 0,
                onClick = { selectedFilter = 0 },
                label = { Text("සියලුම හඬ පට (${allTracks.size})", fontSize = 11.sp) }
            )
            FilterChip(
                selected = selectedFilter == 1,
                onClick = { selectedFilter = 1 },
                label = { Text("පොත 1", fontSize = 11.sp) }
            )
            FilterChip(
                selected = selectedFilter == 2,
                onClick = { selectedFilter = 2 },
                label = { Text("පොත 2", fontSize = 11.sp) }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(filteredTracks) { track ->
                val isTrackActive = activePlayingId == track.id
                AudioTrackCard(
                    track = track,
                    isPlaying = isTrackActive,
                    onPlayClick = {
                        if (isTrackActive) viewModel.stopAudio() else viewModel.playAudioTrack(track)
                    },
                    onOpenLesson = {
                        val lesson = viewModel.repository.getLessonById(track.lessonId)
                        if (lesson != null) {
                            viewModel.openLesson(lesson)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun AudioTrackCard(
    track: AudioTrackItem,
    isPlaying: Boolean,
    onPlayClick: () -> Unit,
    onOpenLesson: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isPlaying) 3.dp else 1.dp),
        border = if (isPlaying) androidx.compose.foundation.BorderStroke(1.5.dp, KoreanBluePrimary) else null,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = track.titleKorean,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = track.titleSinhala,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    onClick = onPlayClick,
                    shape = CircleShape,
                    color = if (isPlaying) KoreanRedAccent else KoreanBluePrimary,
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = if (isPlaying) Icons.Filled.Stop else Icons.Filled.PlayArrow,
                            contentDescription = "හඬ පටය අසන්න",
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "💬 \"${track.textToSpeak}\"",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CategoryBadge(text = "පාඩම ${track.lessonId} (පොත ${track.bookId})")

                Text(
                    text = "සම්පූර්ණ පාඩම බලන්න →",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = KoreanBluePrimary,
                    modifier = Modifier.clickable(onClick = onOpenLesson)
                )
            }
        }
    }
}
