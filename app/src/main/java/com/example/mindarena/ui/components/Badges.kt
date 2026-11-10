package com.example.mindarena.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindarena.ui.theme.BadgeEasyBg
import com.example.mindarena.ui.theme.BadgeEasyText
import com.example.mindarena.ui.theme.BadgeHardBg
import com.example.mindarena.ui.theme.BadgeHardText
import com.example.mindarena.ui.theme.BadgeMediumBg
import com.example.mindarena.ui.theme.BadgeMediumText
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.LiveBadgeBg
import com.example.mindarena.ui.theme.LiveBadgeText
import com.example.mindarena.ui.theme.TagBackground

enum class DifficultyLevel(val label: String, val bgColor: Color, val textColor: Color) {
    EASY("Easy", BadgeEasyBg, BadgeEasyText),
    MEDIUM("Medium", BadgeMediumBg, BadgeMediumText),
    HARD("Hard", BadgeHardBg, BadgeHardText)
}

@Composable
fun DifficultyBadge(
    difficulty: DifficultyLevel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(difficulty.bgColor)
            .padding(horizontal = 8.dp, vertical = 3.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = difficulty.label,
            color = difficulty.textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = DmSansFontFamily
        )
    }
}

@Composable
fun StatusTag(
    text: String,
    modifier: Modifier = Modifier,
    isLive: Boolean = false
) {
    val bgColor = if (isLive) LiveBadgeBg else TagBackground
    val textColor = if (isLive) LiveBadgeText else Espresso

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 3.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text.uppercase(),
            color = textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.5.sp,
            fontFamily = DmSansFontFamily
        )
    }
}
