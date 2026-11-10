package com.example.mindarena.ui.explore

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Language
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
import com.example.mindarena.ui.components.DifficultyBadge
import com.example.mindarena.ui.components.DifficultyLevel
import com.example.mindarena.ui.theme.DmSansFontFamily
import com.example.mindarena.ui.theme.DmSerifDisplayFontFamily
import com.example.mindarena.ui.theme.Espresso
import com.example.mindarena.ui.theme.MutedTaupe
import com.example.mindarena.ui.theme.PaperWhite
import com.example.mindarena.ui.theme.SandBorder
import com.example.mindarena.ui.theme.TagBackground

data class QuizItemData(
    val id: String,
    val title: String,
    val subject: String,
    val difficulty: DifficultyLevel,
    val questionCount: Int,
    val durationMinutes: Int,
    val icon: ImageVector,
    val author: String? = null,
    val questionType: String = "MCQ", // MCQ or Written
    val isPopular: Boolean = false,
    val isNew: Boolean = false
)

val mockQuizzes = listOf(
    QuizItemData(
        id = "1",
        title = "The World Around Us",
        subject = "General Knowledge",
        difficulty = DifficultyLevel.MEDIUM,
        questionCount = 10,
        durationMinutes = 5,
        icon = Icons.Outlined.Language,
        questionType = "MCQ",
        isPopular = true
    ),
    QuizItemData(
        id = "2",
        title = "Fundamentals of Programming",
        subject = "Technology",
        difficulty = DifficultyLevel.EASY,
        questionCount = 15,
        durationMinutes = 8,
        icon = Icons.Outlined.Code,
        questionType = "MCQ",
        isNew = true
    ),
    QuizItemData(
        id = "3",
        title = "Mathematical Reasoning",
        subject = "Mathematics",
        difficulty = DifficultyLevel.HARD,
        questionCount = 20,
        durationMinutes = 12,
        icon = Icons.Outlined.Calculate,
        questionType = "Written",
        isPopular = true
    ),
    QuizItemData(
        id = "4",
        title = "Explore the Human Body",
        subject = "Science",
        difficulty = DifficultyLevel.MEDIUM,
        questionCount = 12,
        durationMinutes = 10,
        icon = Icons.Outlined.FavoriteBorder,
        author = "Dr. Aris Thorne",
        questionType = "MCQ",
        isNew = true
    )
)

@Composable
fun QuizCardItem(
    quiz: QuizItemData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(PaperWhite)
            .border(1.dp, SandBorder, RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon Circle
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(TagBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = quiz.icon,
                contentDescription = quiz.subject,
                tint = Espresso,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(14.dp))

        // Center Details Column (Title wraps naturally)
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = quiz.title,
                color = Espresso,
                fontSize = 17.sp,
                fontFamily = DmSerifDisplayFontFamily,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Subject + Difficulty Row
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = quiz.subject,
                    color = MutedTaupe,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = DmSansFontFamily
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "•",
                    color = MutedTaupe,
                    fontSize = 12.sp
                )

                Spacer(modifier = Modifier.width(6.dp))

                DifficultyBadge(difficulty = quiz.difficulty)
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Stats / Author Row
            val metaText = if (quiz.author != null) {
                "By ${quiz.author}  •  ${quiz.durationMinutes} min"
            } else {
                "${quiz.questionCount} Questions  •  ${quiz.durationMinutes} min"
            }

            Text(
                text = metaText,
                color = MutedTaupe,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = DmSansFontFamily
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        // Action Chevron Button Circle
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(TagBackground),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = null,
                tint = Espresso,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
