package com.example.mindarena.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.Terracotta

@Composable
fun PrimaryTerracottaButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fullWidth: Boolean = true,
    showArrowForward: Boolean = true,
    useChevron: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = if (fullWidth) modifier.fillMaxWidth().height(48.dp) else modifier.height(44.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Terracotta,
            contentColor = PaperWhite
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = DmSansFontFamily
            )
            if (showArrowForward) {
                Spacer(modifier = Modifier.width(6.dp))
                val icon = if (useChevron) Icons.AutoMirrored.Filled.KeyboardArrowRight else Icons.AutoMirrored.Filled.ArrowForward
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = PaperWhite,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
