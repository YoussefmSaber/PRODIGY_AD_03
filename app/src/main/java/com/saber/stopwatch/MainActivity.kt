package com.saber.stopwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.saber.stopwatch.componants.ControlButtons
import com.saber.stopwatch.componants.LapDisplay
import com.saber.stopwatch.componants.StopwatchDisplay
import com.saber.stopwatch.ui.theme.StopwatchTheme
import com.saber.stopwatch.viewmodel.StopwatchViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StopwatchTheme {
                Scaffold(
                ) { innerPadding ->
                    StopWatchApp(innerPadding)
                }
            }
        }
    }
}

@Composable
private fun StopWatchApp(
    innerPadding: PaddingValues,
    stopwatchViewModel: StopwatchViewModel = koinViewModel()
) {
    val timeInMillis by remember { stopwatchViewModel.timeInMillis }
    val isRunning by remember { stopwatchViewModel.isRunning }
    val lapTimes by remember { stopwatchViewModel.lapTimes }
    ConstraintLayout(
        Modifier
            .padding(innerPadding)
            .background(Color(0xFFfefae0))
            .fillMaxHeight(),
    ) {
        val (stopwatchDisplay, controlButtons, lapDisplay) = createRefs()
        Box(modifier = Modifier.constrainAs(lapDisplay) {
            bottom.linkTo(stopwatchDisplay.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            LapDisplay(lapTimes, formatTime = stopwatchViewModel::formatTime)
        }
        Spacer(Modifier.height(16.dp))

        Box(modifier = Modifier.constrainAs(stopwatchDisplay) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }) {
            StopwatchDisplay(timeInMillis, formatTime = stopwatchViewModel::formatTime)
        }

        Spacer(Modifier.height(16.dp))
        Box(modifier = Modifier.constrainAs(controlButtons) {
            top.linkTo(stopwatchDisplay.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            ControlButtons(
                isRunning = isRunning,
                onStartStopClick = {
                    if (isRunning) {
                        stopwatchViewModel.stopStopwatch()
                    } else {
                        stopwatchViewModel.startStopwatch()
                    }
                },
                onResetClick = { stopwatchViewModel.resetStopwatch() },
                onLapClick = { stopwatchViewModel.addLap() }
            )
        }
    }
}