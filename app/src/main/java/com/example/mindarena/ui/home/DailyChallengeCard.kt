package com.example.mindarena.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindarena.ui.components.PrimaryTerracottaButton
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.DmSerifDisplayFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.MutedTaupe
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.Terracotta

@Composable
fun DailyChallengeCard(
    onStartChallenge: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Espresso)
            .padding(20.dp)
    ) {
        // Top row tag and challenge number
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "DAILY CHALLENGE",
                color = Terracotta,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp,
                fontFamily = DmSansFontFamily
            )

            Text(
                text = "#094",
                color = MutedTaupe,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = DmSansFontFamily
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Title
        Text(
            text = "How far can you go?",
            color = PaperWhite,
            fontSize = 26.sp,
            fontFamily = DmSerifDisplayFontFamily
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Description
        Text(
            text = "Put your knowledge to the test with today's challenge.",
            color = PaperWhite.copy(alpha = 0.85f),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontFamily = DmSansFontFamily
        )

        Spacer(modifier = Modifier.height(14.dp))

        // Metadata
        Text(
            text = "General Knowledge  •  10 Questions  •  5 min",
            color = MutedTaupe,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = DmSansFontFamily
        )

        Spacer(modifier = Modifier.height(18.dp))

        // Action Button
        PrimaryTerracottaButton(
            text = "Start Challenge",
            onClick = onStartChallenge
        )
    }
}
