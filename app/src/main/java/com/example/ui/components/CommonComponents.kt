package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanRedAccent

@Composable
fun AudioSpeakerButton(
    onClick: () -> Unit,
    isPlaying: Boolean = false,
    modifier: Modifier = Modifier,
    testTag: String = "audio_speaker_button"
) {
    Surface(
        onClick = onClick,
        modifier = modifier
            .testTag(testTag)
            .size(44.dp),
        shape = CircleShape,
        color = if (isPlaying) KoreanRedAccent else KoreanBlueLight,
        tonalElevation = 2.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = if (isPlaying) Icons.Filled.GraphicEq else Icons.Filled.VolumeUp,
                contentDescription = "හඬ පටය අසන්න (Listen Audio)",
                tint = if (isPlaying) Color.White else KoreanBluePrimary,
                modifier = Modifier.size(22.dp)
            )
        }
    }
}

@Composable
fun CategoryBadge(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = KoreanBlueLight,
    contentColor: Color = KoreanBluePrimary
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            text = text,
            color = contentColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun PhoneticSinhalaText(
    koreanText: String,
    pronunciationSinhala: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = koreanText,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        if (pronunciationSinhala.isNotBlank()) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "[$pronunciationSinhala]",
                fontSize = 12.sp,
                color = KoreanRedAccent,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun SpeedSelector(
    currentSpeed: Float,
    onSpeedSelected: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    val speeds = listOf(0.75f to "0.75x (සෙමින්)", 1.0f to "1.0x (සාමාන්‍ය)", 1.25f to "1.25x (වේගවත්)")
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "වේගය:",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(end = 6.dp)
        )
        speeds.forEach { (speed, label) ->
            val isSelected = currentSpeed == speed
            Box(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isSelected) KoreanBluePrimary else MaterialTheme.colorScheme.surfaceVariant)
                    .clickable { onSpeedSelected(speed) }
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = label,
                    fontSize = 11.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
