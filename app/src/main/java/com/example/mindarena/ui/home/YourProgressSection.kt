package com.example.mindarena.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.DmSerifDisplayFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.MutedTaupe
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.Terracotta

@Composable
fun YourProgressSection(
    completedQuizzes: Int = 24,
    avgAccuracy: Int = 88,
    totalPoints: String = "1,420",
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Your Progress",
            color = Espresso,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = DmSansFontFamily
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ProgressStatCard(
                value = "$completedQuizzes",
                label = "Completed",
                modifier = Modifier.weight(1f)
            )

            ProgressStatCard(
                value = "$avgAccuracy%",
                label = "Accuracy",
                modifier = Modifier.weight(1f)
            )

            ProgressStatCard(
                value = totalPoints,
                label = "Total Points",
                modifier = Modifier.weight(1f),
                isTerracottaValue = true
            )
        }
    }
}

@Composable
private fun ProgressStatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    isTerracottaValue: Boolean = false
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(PaperWhite)
            .border(1.dp, SandBorder, RoundedCornerShape(16.dp))
            .padding(vertical = 14.dp, horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = if (isTerracottaValue) Terracotta else Espresso,
            fontSize = 22.sp,
            fontFamily = DmSerifDisplayFontFamily
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            color = MutedTaupe,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = DmSansFontFamily
        )
    }
}
