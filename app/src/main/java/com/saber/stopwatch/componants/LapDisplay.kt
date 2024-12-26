package com.saber.stopwatch.componants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LapDisplay(lapTimes: List<Long>, formatTime: (Long) -> String) {
    if (lapTimes.isNotEmpty()) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(8.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                lapTimes.forEachIndexed { index, lap ->
                    Text(
                        text = "Lap ${index + 1}: ${formatTime(lap)}",
                        fontSize = 20.sp,
                        color = Color(0xFF6c757d)
                    )
                }
            }
            Text(
                "Laps", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF1d2d44)
            )
        }
    }
}