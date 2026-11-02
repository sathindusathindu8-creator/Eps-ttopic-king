package com.example.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.viewmodel.MainNavigationTab

@Composable
fun EpsBottomNavigationBar(
    currentTab: MainNavigationTab,
    onTabSelected: (MainNavigationTab) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.testTag("eps_bottom_nav_bar")
    ) {
        NavigationBarItem(
            selected = currentTab == MainNavigationTab.HOME,
            onClick = { onTabSelected(MainNavigationTab.HOME) },
            icon = { Icon(Icons.Filled.Home, contentDescription = "මුල් පිටුව") },
            label = { Text("මුල් පිටුව", fontSize = 11.sp, fontWeight = FontWeight.Medium) },
            modifier = Modifier.testTag("nav_item_home")
        )
        NavigationBarItem(
            selected = currentTab == MainNavigationTab.BOOK_1 || currentTab == MainNavigationTab.BOOK_2,
            onClick = { onTabSelected(MainNavigationTab.BOOK_1) },
            icon = { Icon(Icons.Filled.Book, contentDescription = "පාඩම්") },
            label = { Text("පාඩම්", fontSize = 11.sp, fontWeight = FontWeight.Medium) },
            modifier = Modifier.testTag("nav_item_lessons")
        )
        NavigationBarItem(
            selected = currentTab == MainNavigationTab.AUDIO_TRACKS,
            onClick = { onTabSelected(MainNavigationTab.AUDIO_TRACKS) },
            icon = { Icon(Icons.Filled.Headphones, contentDescription = "හඬ පට") },
            label = { Text("හඬ පට", fontSize = 11.sp, fontWeight = FontWeight.Medium) },
            modifier = Modifier.testTag("nav_item_audio")
        )
        NavigationBarItem(
            selected = currentTab == MainNavigationTab.EXAM_PAPERS,
            onClick = { onTabSelected(MainNavigationTab.EXAM_PAPERS) },
            icon = { Icon(Icons.Filled.Assignment, contentDescription = "අනුමාන පේපර්") },
            label = { Text("අනුමාන පේපර්", fontSize = 10.sp, fontWeight = FontWeight.Medium) },
            modifier = Modifier.testTag("nav_item_exams")
        )
        NavigationBarItem(
            selected = currentTab == MainNavigationTab.VOCAB_SEARCH,
            onClick = { onTabSelected(MainNavigationTab.VOCAB_SEARCH) },
            icon = { Icon(Icons.Filled.Search, contentDescription = "වචන කෝෂය") },
            label = { Text("වචන සෙවුම", fontSize = 11.sp, fontWeight = FontWeight.Medium) },
            modifier = Modifier.testTag("nav_item_vocab")
        )
    }
}
