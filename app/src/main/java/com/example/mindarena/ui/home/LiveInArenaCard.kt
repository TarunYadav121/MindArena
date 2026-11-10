package com.example.mindarena.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.example.mindarena.ui.components.StatusTag
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.MutedTaupe
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.Terracotta

@Composable
fun LiveInArenaSection(
    onJoinRoom: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Section Header Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Terracotta)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Live in the Arena",
                    color = Espresso,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = DmSansFontFamily
                )
            }

            StatusTag(text = "LIVE", isLive = true)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // White Card Surface
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(PaperWhite)
                .border(1.dp, SandBorder, RoundedCornerShape(18.dp))
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    StatusTag(text = "MULTIPLAYER")

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "•  18 players competing",
                        color = MutedTaupe,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = DmSansFontFamily
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Speed Trivia: Science &\nCosmos",
                    color = Espresso,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = DmSansFontFamily,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(12.dp))

                PrimaryTerracottaButton(
                    text = "Join Room",
                    onClick = onJoinRoom,
                    fullWidth = false,
                    useChevron = true
                )
            }
        }
    }
}
