package com.example.mindarena.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindarena.ui.components.MindArenaHeader
import com.example.mindarena.ui.theme.DmSerifDisplayFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.WarmCream

@Composable
fun HomeScreen(
    onNavigateToExplore: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(WarmCream)
    ) {
        // Shared Header
        MindArenaHeader(
            onNotificationClick = onNotificationClick,
            onProfileClick = onProfileClick
        )

        // Scrollable Content Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp)
                .padding(bottom = 100.dp) // Bottom padding for floating navigation bar
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            // Editorial Welcome Heading
            Text(
                text = "Every answer moves you\nup.",
                color = Espresso,
                fontSize = 32.sp,
                lineHeight = 38.sp,
                fontFamily = DmSerifDisplayFontFamily
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Daily Challenge Card
            DailyChallengeCard(
                onStartChallenge = { /* Handle challenge */ }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Live in the Arena
            LiveInArenaSection(
                onJoinRoom = { /* Handle join room */ }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Quick Access Section (All 3 items)
            QuickAccessSection(
                onJoinLiveQuiz = { /* Handle live quiz */ },
                onCreateChallenge = { /* Handle create */ },
                onPracticeSolo = { /* Handle solo */ }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Your Progress Section
            YourProgressSection()

            Spacer(modifier = Modifier.height(24.dp))

            // Daily Streak Card
            DailyStreakCard()

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
