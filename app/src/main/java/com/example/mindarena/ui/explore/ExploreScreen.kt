package com.example.mindarena.ui.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindarena.ui.components.DifficultyLevel
import com.example.mindarena.ui.components.FilterBottomSheet
import com.example.mindarena.ui.components.FilterState
import com.example.mindarena.ui.components.MindArenaHeader
import com.example.mindarena.ui.components.MindArenaSearchBar
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.DmSerifDisplayFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.MutedTaupe
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.TagBackground
import com.example.mindarena.ui.theme.Terracotta
import com.example.mindarena.ui.theme.WarmCream

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onQuizClick: (QuizItemData) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedSubject by remember { mutableStateOf<String?>(null) }
    var selectedTab by remember { mutableStateOf("All") }
    var filterState by remember { mutableStateOf(FilterState()) }
    var showFilterSheet by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    // Active filtering & sorting logic over mock quiz dataset
    val filteredQuizzes = remember(searchQuery, selectedSubject, selectedTab, filterState) {
        mockQuizzes.filter { quiz ->
            // Search filter
            val matchesSearch = searchQuery.isBlank() ||
                quiz.title.contains(searchQuery, ignoreCase = true) ||
                quiz.subject.contains(searchQuery, ignoreCase = true)

            // Subject filter
            val matchesSubject = selectedSubject == null || quiz.subject.equals(selectedSubject, ignoreCase = true)

            // Discovery tab filter
            val matchesTab = when (selectedTab) {
                "Popular" -> quiz.isPopular
                "New" -> quiz.isNew
                else -> true
            }

            // Difficulty filter
            val matchesDifficulty = when (filterState.difficulty) {
                "Easy" -> quiz.difficulty == DifficultyLevel.EASY
                "Medium" -> quiz.difficulty == DifficultyLevel.MEDIUM
                "Hard" -> quiz.difficulty == DifficultyLevel.HARD
                else -> true
            }

            // Question Type filter
            val matchesType = when (filterState.questionType) {
                "MCQ" -> quiz.questionType == "MCQ"
                "Written" -> quiz.questionType == "Written"
                else -> true
            }

            // Duration filter
            val matchesDuration = when (filterState.duration) {
                "Short" -> quiz.durationMinutes < 7
                "Medium" -> quiz.durationMinutes in 7..10
                "Long" -> quiz.durationMinutes > 10
                else -> true
            }

            matchesSearch && matchesSubject && matchesTab && matchesDifficulty && matchesType && matchesDuration
        }.sortedWith(
            when (filterState.sortBy) {
                "Popular" -> compareByDescending { it.isPopular }
                "Newest" -> compareByDescending { it.isNew }
                else -> compareBy { it.id }
            }
        )
    }

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
                .padding(bottom = 100.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            // Screen Heading
            Text(
                text = "Explore",
                color = Espresso,
                fontSize = 32.sp,
                fontFamily = DmSerifDisplayFontFamily
            )

            Text(
                text = "Find your next challenge.",
                color = MutedTaupe,
                fontSize = 14.sp,
                fontFamily = DmSansFontFamily,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Search Bar (Input field only)
            MindArenaSearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Browse Subjects Row Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Browse Subjects",
                    color = Espresso,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = DmSansFontFamily
                )

                Text(
                    text = "View all",
                    color = Terracotta,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = DmSansFontFamily,
                    modifier = Modifier.clickable { selectedSubject = null }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Horizontally Scrollable Subject Chips
            BrowseSubjectsRow(
                selectedSubject = selectedSubject,
                onSubjectSelect = { selectedSubject = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Filter Tabs Row (Discovery tabs + Filter button beside them)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left Discovery Tabs Container (All / Popular / New)
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(TagBackground)
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    listOf("All", "Popular", "New").forEach { tab ->
                        val isSelected = selectedTab == tab
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSelected) PaperWhite else TagBackground)
                                .clickable { selectedTab = tab }
                                .padding(horizontal = 14.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = tab,
                                color = if (isSelected) Espresso else MutedTaupe,
                                fontSize = 13.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                fontFamily = DmSansFontFamily
                            )
                        }
                    }
                }

                // Right Filter Button with Active Count Badge
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(PaperWhite)
                        .border(1.dp, SandBorder, RoundedCornerShape(14.dp))
                        .clickable { showFilterSheet = true }
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Tune,
                        contentDescription = "Filter",
                        tint = Espresso,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "Filter",
                        color = Espresso,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = DmSansFontFamily
                    )

                    val activeCount = filterState.activeCount()
                    if (activeCount > 0) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .clip(CircleShape)
                                .background(Terracotta),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "$activeCount",
                                color = PaperWhite,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = DmSansFontFamily
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Featured Science Challenge Card
            FeaturedChallengeCard(
                onExploreQuiz = { /* Handle featured quiz */ }
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Discover Quizzes Section Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Discover Quizzes",
                    color = Espresso,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = DmSansFontFamily
                )

                Text(
                    text = "${filteredQuizzes.size} quizzes",
                    color = MutedTaupe,
                    fontSize = 13.sp,
                    fontFamily = DmSansFontFamily
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Discover Quizzes Cards List
            if (filteredQuizzes.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No quizzes found matching your filters.",
                        color = MutedTaupe,
                        fontSize = 14.sp,
                        fontFamily = DmSansFontFamily
                    )
                }
            } else {
                filteredQuizzes.forEachIndexed { index, quiz ->
                    QuizCardItem(
                        quiz = quiz,
                        onClick = { onQuizClick(quiz) }
                    )
                    if (index < filteredQuizzes.lastIndex) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }

    // Modal Filter Bottom Sheet
    if (showFilterSheet) {
        FilterBottomSheet(
            filterState = filterState,
            onFilterChange = { filterState = it },
            onDismissRequest = { showFilterSheet = false }
        )
    }
}
