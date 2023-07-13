package com.cheesecake.pizzaapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cheesecake.pizzaapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_semibold)),
        fontWeight = FontWeight(700),
        fontSize = 32.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_semibold)),
        fontWeight = FontWeight(700),
        fontSize = 26.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(500),
        fontSize = 26.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(500),
        fontSize = 16.sp,
    ),
)