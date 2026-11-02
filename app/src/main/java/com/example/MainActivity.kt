package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.EpsBottomNavigationBar
import com.example.ui.screens.AudioTracksScreen
import com.example.ui.screens.ExamSimulatorScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.LessonsScreen
import com.example.ui.screens.VocabSearchScreen
import com.example.ui.theme.KoreanBlueLight
import com.example.ui.theme.KoreanBluePrimary
import com.example.ui.theme.KoreanRedAccent
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.EpsViewModel
import com.example.ui.viewmodel.MainNavigationTab

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                EpsApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpsApp(
    viewModel: EpsViewModel = viewModel()
) {
    val currentTab by viewModel.currentTab.collectAsState()
    val selectedLesson by viewModel.selectedLesson.collectAsState()
    val examSession by viewModel.examSession.collectAsState()
    val isSpeaking by viewModel.isSpeaking.collectAsState()

    // Handle back button logically
    BackHandler(enabled = selectedLesson != null || examSession != null || currentTab != MainNavigationTab.HOME) {
        when {
            selectedLesson != null -> viewModel.closeLesson()
            examSession != null -> viewModel.exitExam()
            currentTab != MainNavigationTab.HOME -> viewModel.setTab(MainNavigationTab.HOME)
        }
    }

    // Hide bottom navigation during active CBT exam session or detailed lesson to maximize focus and space
    val showBottomBar = examSession == null && selectedLesson == null

    Scaffold(
        topBar = {
            if (selectedLesson == null && examSession == null) {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = KoreanBluePrimary,
                                modifier = Modifier.size(34.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Filled.School,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "EPS-TOPIK කොරියානු",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Book 1 & 2 • හඬ පට • CBT අනුමාන පේපර්",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    },
                    actions = {
                        if (isSpeaking) {
                            Surface(
                                shape = CircleShape,
                                color = KoreanRedAccent,
                                modifier = Modifier
                                    .padding(end = 12.dp)
                                    .size(28.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        Icons.Filled.VolumeUp,
                                        contentDescription = "Playing Audio",
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        },
        bottomBar = {
            if (showBottomBar) {
                EpsBottomNavigationBar(
                    currentTab = currentTab,
                    onTabSelected = { viewModel.setTab(it) }
                )
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .testTag("eps_main_scaffold")
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                selectedLesson != null -> {
                    LessonDetailScreen(
                        lesson = selectedLesson!!,
                        viewModel = viewModel
                    )
                }
                currentTab == MainNavigationTab.HOME -> {
                    HomeScreen(viewModel = viewModel)
                }
                currentTab == MainNavigationTab.BOOK_1 || currentTab == MainNavigationTab.BOOK_2 -> {
                    LessonsScreen(viewModel = viewModel)
                }
                currentTab == MainNavigationTab.AUDIO_TRACKS -> {
                    AudioTracksScreen(viewModel = viewModel)
                }
                currentTab == MainNavigationTab.EXAM_PAPERS -> {
                    ExamSimulatorScreen(viewModel = viewModel)
                }
                currentTab == MainNavigationTab.VOCAB_SEARCH -> {
                    VocabSearchScreen(viewModel = viewModel)
                }
            }
        }
    }
}
