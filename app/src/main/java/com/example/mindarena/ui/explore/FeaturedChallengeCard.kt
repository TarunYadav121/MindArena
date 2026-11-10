package com.example.mindarena.ui.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Biotech
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindarena.ui.components.DifficultyBadge
import com.example.mindarena.ui.components.DifficultyLevel
import com.example.mindarena.ui.components.PrimaryTerracottaButton
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.DmSerifDisplayFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.MutedTaupe
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.Terracotta

@Composable
fun FeaturedChallengeCard(
    onExploreQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(PaperWhite)
            .border(1.dp, SandBorder, RoundedCornerShape(18.dp))
            .padding(20.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header tag row & microscope graphic icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "EDITOR'S PICK  •  Curated Challenge",
                        color = Terracotta,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp,
                        fontFamily = DmSansFontFamily
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "The Science Challenge",
                        color = Espresso,
                        fontSize = 24.sp,
                        fontFamily = DmSerifDisplayFontFamily
                    )
                }

                // Decorative Microscope Graphic Icon
                Icon(
                    imageVector = Icons.Outlined.Biotech,
                    contentDescription = null,
                    tint = Espresso.copy(alpha = 0.15f),
                    modifier = Modifier.size(52.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Body text
            Text(
                text = "Explore how much you really know about the microscopic world and physical phenomena around you.",
                color = MutedTaupe,
                fontSize = 13.sp,
                lineHeight = 19.sp,
                fontFamily = DmSansFontFamily
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Metadata row
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "15 Questions  •  ",
                    color = Espresso,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = DmSansFontFamily
                )

                DifficultyBadge(difficulty = DifficultyLevel.MEDIUM)

                Text(
                    text = "  •  8 min",
                    color = Espresso,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = DmSansFontFamily
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Button
            PrimaryTerracottaButton(
                text = "Explore Quiz",
                onClick = onExploreQuiz,
                fullWidth = false
            )
        }
    }
}
