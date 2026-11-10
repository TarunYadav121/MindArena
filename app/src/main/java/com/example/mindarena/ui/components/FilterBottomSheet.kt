package com.example.mindarena.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.example.mindarena.ui.theme.SelectedBackground
import com.example.mindarena.ui.theme.Terracotta
import com.example.mindarena.ui.theme.WarmCream

data class FilterState(
    val difficulty: String = "All",
    val questionType: String = "All",
    val duration: String = "All",
    val sortBy: String = "Recommended"
) {
    fun activeCount(): Int {
        var count = 0
        if (difficulty != "All") count++
        if (questionType != "All") count++
        if (duration != "All") count++
        if (sortBy != "Recommended") count++
        return count
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterBottomSheet(
    filterState: FilterState,
    onFilterChange: (FilterState) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        containerColor = WarmCream,
        dragHandle = null
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Sheet Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Filter & Sort",
                    fontSize = 22.sp,
                    fontFamily = DmSerifDisplayFontFamily,
                    color = Espresso
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(onClick = { onFilterChange(FilterState()) }) {
                        Text(
                            text = "Reset",
                            color = Terracotta,
                            fontSize = 14.sp,
                            fontFamily = DmSansFontFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    IconButton(onClick = onDismissRequest) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Espresso
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 1. Difficulty Filter Section
            FilterSectionTitle("Difficulty")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("All", "Easy", "Medium", "Hard").forEach { option ->
                    FilterChipItem(
                        text = option,
                        isSelected = filterState.difficulty == option,
                        onClick = { onFilterChange(filterState.copy(difficulty = option)) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 2. Question Type Section
            FilterSectionTitle("Question Type")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("All", "MCQ", "Written").forEach { option ->
                    FilterChipItem(
                        text = option,
                        isSelected = filterState.questionType == option,
                        onClick = { onFilterChange(filterState.copy(questionType = option)) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 3. Duration Section
            FilterSectionTitle("Duration")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("All", "Short", "Medium", "Long").forEach { option ->
                    FilterChipItem(
                        text = option,
                        isSelected = filterState.duration == option,
                        onClick = { onFilterChange(filterState.copy(duration = option)) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 4. Sort By Section
            FilterSectionTitle("Sort By")
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Recommended", "Popular", "Newest").forEach { option ->
                    FilterChipItem(
                        text = option,
                        isSelected = filterState.sortBy == option,
                        onClick = { onFilterChange(filterState.copy(sortBy = option)) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Apply Button
            PrimaryTerracottaButton(
                text = "Apply Filters",
                onClick = onDismissRequest
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun FilterSectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = DmSansFontFamily,
        color = Espresso,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun FilterChipItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val bgColor = if (isSelected) Terracotta else PaperWhite
    val textColor = if (isSelected) PaperWhite else Espresso
    val borderColor = if (isSelected) Terracotta else SandBorder

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .border(1.dp, borderColor, RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 13.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            fontFamily = DmSansFontFamily
        )
    }
}
