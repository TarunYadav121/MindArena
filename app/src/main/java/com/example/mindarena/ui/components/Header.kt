package com.example.mindarena.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.Terracotta

@Composable
fun MindArenaHeader(
    modifier: Modifier = Modifier,
    userInitials: String? = null,
    onNotificationClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo Badge ('M' in Terracotta block)
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Terracotta),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "M",
                color = PaperWhite,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = DmSerifDisplayFontFamily
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        // App Brand Name: Mind (Espresso) Arena (Terracotta)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Mind",
                color = Espresso,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = DmSansFontFamily
            )
            Text(
                text = "Arena",
                color = Terracotta,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = DmSansFontFamily
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Notification Bell Icon Button
        IconButton(
            onClick = onNotificationClick,
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
                .border(1.dp, SandBorder, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notifications",
                tint = Espresso,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        // Neutral Profile Avatar Placeholder (or initials if provided)
        IconButton(
            onClick = onProfileClick,
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
                .background(SandBorder)
        ) {
            if (!userInitials.isNullOrBlank()) {
                Text(
                    text = userInitials,
                    color = Espresso,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = DmSansFontFamily
                )
            } else {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profile",
                    tint = Espresso,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}
