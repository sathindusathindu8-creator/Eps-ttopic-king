package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.KoreanBlueDark
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanGoldAmber
import com.example.ui.theme.KoreanGoldLight
import com.example.ui.theme.KoreanRedAccent
import com.example.ui.theme.KoreanRedLight
import com.example.ui.viewmodel.EpsViewModel
import com.example.ui.viewmodel.MainNavigationTab

@Composable
fun HomeScreen(
    viewModel: EpsViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("home_screen_lazy_column"),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 32.dp)
    ) {
        // Hero Banner Graphic
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.korean_hero_banner_1793594679266),
                    contentDescription = "EPS TOPIK Korean Study Banner",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.Crop
                )
            }
        }

        // Welcome & App Overview Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = KoreanBlueLight,
                            modifier = Modifier.size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Filled.School,
                                    contentDescription = null,
                                    tint = KoreanBluePrimary
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "EPS-TOPIK කොරියානු පාඨමාලාව",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "ශ්‍රී ලාංකික සිසුන් සඳහා විශේෂිත අධ්‍යයන සහායක",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "EPS-TOPIK නිල පෙළපොත් 1 සහ 2 හි සියලුම පාඩම්, අත්‍යවශ්‍ය වචන, දෛනික සංවාද, පැහැදිලි ව්‍යාකරණ, ස්වදේශික කොරියානු හඬ පට (Audio) සහ CBT අනුමාන ප්‍රශ්න පත්‍ර මෙහි ඇතුළත් වේ.",
                        fontSize = 13.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        // Quick Navigation Grid
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "ප්‍රධාන අංශ වෙත පිවිසෙන්න",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    QuickActionCard(
                        title = "පොත 1 (පාඩම් 1-30)",
                        subtitle = "හෝඩිය, මූලික සංවාද සහ එදිනෙදා ජීවිතය",
                        icon = Icons.Filled.MenuBook,
                        accentColor = KoreanBluePrimary,
                        backgroundColor = KoreanBlueLight,
                        modifier = Modifier.weight(1f),
                        testTag = "home_card_book1",
                        onClick = { viewModel.setTab(MainNavigationTab.BOOK_1) }
                    )
                    QuickActionCard(
                        title = "පොත 2 (පාඩම් 31-60)",
                        subtitle = "වැඩබිම් ආයුධ, යන්ත්‍ර, ආරක්ෂාව හා ගිවිසුම්",
                        icon = Icons.Filled.Book,
                        accentColor = KoreanRedAccent,
                        backgroundColor = KoreanRedLight,
                        modifier = Modifier.weight(1f),
                        testTag = "home_card_book2",
                        onClick = { viewModel.setTab(MainNavigationTab.BOOK_2) }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    QuickActionCard(
                        title = "සංවාද හඬ පට",
                        subtitle = "පාඩම් සංවාදවලට සවන් දී පුහුණු වන්න",
                        icon = Icons.Filled.Headphones,
                        accentColor = KoreanGoldAmber,
                        backgroundColor = KoreanGoldLight,
                        modifier = Modifier.weight(1f),
                        testTag = "home_card_audio",
                        onClick = { viewModel.setTab(MainNavigationTab.AUDIO_TRACKS) }
                    )
                    QuickActionCard(
                        title = "අනුමාන පේපර්",
                        subtitle = "CBT විභාග පරිගණක අනුකරණය සහ විවරණ",
                        icon = Icons.Filled.Assignment,
                        accentColor = Color(0xFF2E7D32),
                        backgroundColor = Color(0xFFE8F5E9),
                        modifier = Modifier.weight(1f),
                        testTag = "home_card_exams",
                        onClick = { viewModel.setTab(MainNavigationTab.EXAM_PAPERS) }
                    )
                }
            }
        }

        // Hangul Alphabet Quick Pronunciation Bar
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "මූලික කොරියානු අක්ෂර උච්චාරණය (한글 발음)",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "අක්ෂරය මත තට්ටු කර ස්වදේශික හඬ අසන්න:",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    val basicLetters = listOf(
                        Triple("가", "ගා", "ga"),
                        Triple("나", "නා", "na"),
                        Triple("다", "දා", "da"),
                        Triple("라", "රා", "ra"),
                        Triple("마", "මා", "ma"),
                        Triple("바", "බා", "ba"),
                        Triple("사", "සා", "sa"),
                        Triple("아", "ආ", "a"),
                        Triple("자", "ජා", "ja"),
                        Triple("차", "චා", "cha"),
                        Triple("카", "කා", "ka"),
                        Triple("타", "තා", "ta"),
                        Triple("파", "පා", "pa"),
                        Triple("하", "හා", "ha")
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        basicLetters.take(7).forEach { (hangul, sinhala, _) ->
                            HangulLetterChip(
                                hangul = hangul,
                                sinhala = sinhala,
                                onClick = { viewModel.speakWord(hangul) }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        basicLetters.drop(7).forEach { (hangul, sinhala, _) ->
                            HangulLetterChip(
                                hangul = hangul,
                                sinhala = sinhala,
                                onClick = { viewModel.speakWord(hangul) }
                            )
                        }
                    }
                }
            }
        }

        // Exam Tips for Sri Lankan Candidates
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.CheckCircle,
                            contentDescription = null,
                            tint = KoreanBluePrimary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "EPS-TOPIK විභාගය සාර්ථක කර ගැනීමට උපදෙස්",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "• කියවීම (읽기) ප්‍රශ්න 20 (ලකුණු 100) සහ සවන්දීම (듣기) ප්‍රශ්න 20 (ලකුණු 100) ලෙස සම්පූර්ණ ලකුණු 200 කි.\n• සාමාන්‍යයෙන් නිෂ්පාදන (Manufacturing) ක්ෂේත්‍රය සඳහා අවම ලකුණු 110-140 ක් ලබා ගැනීම වඩාත් සුදුසුය.\n• වැඩබිමේදී අත්‍යවශ්‍ය වන ආරක්ෂක උපකරණ, ආයුධ සහ යන්ත්‍රෝපකරණ වචන පිළිබඳව විශේෂයෙන් අවධානය යොමු කරන්න.",
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun QuickActionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    accentColor: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    testTag: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .testTag(testTag)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Surface(
                shape = CircleShape,
                color = Color.White.copy(alpha = 0.9f),
                modifier = Modifier.size(36.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(imageVector = icon, contentDescription = null, tint = accentColor, modifier = Modifier.size(20.dp))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = subtitle, fontSize = 11.sp, lineHeight = 14.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
fun HangulLetterChip(
    hangul: String,
    sinhala: String,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        color = KoreanBlueLight,
        modifier = Modifier.size(42.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = hangul, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = KoreanBluePrimary)
            Text(text = sinhala, fontSize = 9.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
