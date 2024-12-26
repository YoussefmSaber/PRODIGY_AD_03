package com.saber.stopwatch.componants

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StopwatchDisplay(timeInMillis: Long, formatTime: (Long) -> String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = formatTime(timeInMillis),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}