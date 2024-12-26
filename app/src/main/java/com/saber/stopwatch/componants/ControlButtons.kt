package com.saber.stopwatch.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ControlButtons(
    isRunning: Boolean,
    onStartStopClick: () -> Unit,
    onResetClick: () -> Unit,
    onLapClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onStartStopClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFddb892)
            )
        ) {
            Text(if (isRunning) "Pause" else "Start")
        }
        Button(
            onClick = onResetClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFddb892)
            )
        ) {
            Text("Reset")
        }
        Button(
            onClick = onLapClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFddb892)
            )
        ) {
            Text("Lap")
        }
    }
}