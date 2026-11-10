package com.example.mindarena.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mindarena.ui.components.LiquidGlassBottomNavigation
import com.example.mindarena.ui.components.NavigationTab
// import com.example.mindarena.ui.explore.ExploreScreen
import com.example.mindarena.ui.home.HomeScreen
import com.example.mindarena.ui.theme.WarmCream

@Composable
fun MainContainer(
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(NavigationTab.HOME) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(WarmCream)
    ) {
        // Render current screen based on selected bottom navigation tab
        when (selectedTab) {
            NavigationTab.HOME -> {
                HomeScreen(
                    onNavigateToExplore = { selectedTab = NavigationTab.EXPLORE }
                )
            }
            NavigationTab.EXPLORE -> {
                // ExploreScreen() -- temporarily commented out while explore folder is pushed from friend's account
                HomeScreen(
                    onNavigateToExplore = { selectedTab = NavigationTab.EXPLORE }
                )
            }
            NavigationTab.CREATE, NavigationTab.PROFILE -> {
                // Fallback / placeholder content for Create and Profile destinations
                HomeScreen(
                    onNavigateToExplore = { selectedTab = NavigationTab.EXPLORE }
                )
            }
        }

        // Floating Liquid Glass Bottom Navigation Overlay
        LiquidGlassBottomNavigation(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}
