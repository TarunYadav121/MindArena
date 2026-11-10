package com.example.mindarena.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.FlashOn
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindarena.ui.components.StatusTag
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.MutedTaupe
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.TagBackground

data class QuickAccessItemData(
    val title: String,
    val subtitle: String,
    val badgeText: String,
    val icon: ImageVector,
    val onClick: () -> Unit
)

@Composable
fun QuickAccessSection(
    onJoinLiveQuiz: () -> Unit,
    onCreateChallenge: () -> Unit,
    onPracticeSolo: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        QuickAccessItemData(
            title = "Join a Live Quiz",
            subtitle = "Enter a room code and compete",
            badgeText = "Code",
            icon = Icons.Outlined.FlashOn,
            onClick = onJoinLiveQuiz
        ),
        QuickAccessItemData(
            title = "Create a Challenge",
            subtitle = "Build your own custom quiz",
            badgeText = "Custom",
            icon = Icons.Outlined.AddCircleOutline,
            onClick = onCreateChallenge
        ),
        QuickAccessItemData(
            title = "Practice Solo",
            subtitle = "Self-paced study mode",
            badgeText = "Solo",
            icon = Icons.Outlined.School,
            onClick = onPracticeSolo
        )
    )

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Quick Access",
            color = Espresso,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = DmSansFontFamily
        )

        Spacer(modifier = Modifier.height(12.dp))

        items.forEachIndexed { index, item ->
            QuickAccessCardItem(item = item)
            if (index < items.lastIndex) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
private fun QuickAccessCardItem(item: QuickAccessItemData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(PaperWhite)
            .border(1.dp, SandBorder, RoundedCornerShape(16.dp))
            .clickable(onClick = item.onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon Container Box
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(TagBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = Espresso,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        // Titles
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.title,
                color = Espresso,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = DmSansFontFamily
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = item.subtitle,
                color = MutedTaupe,
                fontSize = 12.sp,
                fontFamily = DmSansFontFamily
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Badge Tag
        StatusTag(text = item.badgeText)

        Spacer(modifier = Modifier.width(6.dp))

        // Right Chevron Arrow
        Icon(
            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = MutedTaupe,
            modifier = Modifier.size(20.dp)
        )
    }
}
