package com.example.pinkauth.commom.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pinkauth.R

val Rubik = FontFamily(
    Font(R.font.rubik_semibold, FontWeight.Normal),
    Font(R.font.rubik_italic, FontWeight.Normal),
    Font(R.font.rubik_regular, FontWeight.Normal),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = Color.Black
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)