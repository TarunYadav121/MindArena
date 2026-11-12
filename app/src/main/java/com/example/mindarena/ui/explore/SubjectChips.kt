package com.example.mindarena.ui.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Science
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
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.Terracotta

data class SubjectItem(
    val name: String,
    val icon: ImageVector
)

val mindArenaSubjects: List<SubjectItem> = listOf(
    SubjectItem("General Knowledge", Icons.Outlined.Language),
    SubjectItem("Science", Icons.Outlined.Science),
    SubjectItem("Technology", Icons.Outlined.Code),
    SubjectItem("Mathematics", Icons.Outlined.Calculate),
    SubjectItem("History", Icons.Outlined.History),
    SubjectItem("English", Icons.AutoMirrored.Outlined.MenuBook),
    SubjectItem("Geography", Icons.Outlined.Map)
)

@Composable
fun BrowseSubjectsRow(
    selectedSubject: String?,
    onSubjectSelect: (String?) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(mindArenaSubjects) { subject ->
            val isSelected = selectedSubject == subject.name
            val bgColor = if (isSelected) Terracotta else PaperWhite
            val textColor = if (isSelected) PaperWhite else Espresso
            val iconColor = if (isSelected) PaperWhite else Terracotta
            val borderColor = if (isSelected) Terracotta else SandBorder

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(14.dp))
                    .background(bgColor)
                    .border(1.dp, borderColor, RoundedCornerShape(14.dp))
                    .clickable {
                        if (isSelected) onSubjectSelect(null) else onSubjectSelect(subject.name)
                    }
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = subject.icon,
                    contentDescription = subject.name,
                    tint = iconColor,
                    modifier = Modifier.size(18.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = subject.name,
                    color = textColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = DmSansFontFamily,
                    maxLines = 1
                )
            }
        }
    }
}
