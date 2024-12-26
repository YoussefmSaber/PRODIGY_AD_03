package com.saber.stopwatch.viewmodel

import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopwatchViewModel : ViewModel() {

    var timeInMillis = mutableLongStateOf(0L)
    var isRunning = mutableStateOf(false)
    var lapTimes = mutableStateOf(listOf<Long>())
    private var lapStartTime = mutableLongStateOf(0L)
    private var isLapRunning = mutableStateOf(false)

    init {
        resetStopwatch()
    }

    fun startStopwatch() {
        isRunning.value = true
        viewModelScope.launch(Dispatchers.IO) {
            while (isRunning.value) {
                delay(10L)
                timeInMillis.value += 10L
            }
        }
    }

    fun stopStopwatch() {
        isRunning.value = false
    }

    fun addLap() {
        if (isRunning.value) {
            lapTimes.value += listOf(timeInMillis.longValue)
            isLapRunning.value = true
            lapStartTime.longValue = timeInMillis.longValue
        }
    }

    fun formatTime(milliseconds: Long): String {
        val hours = (milliseconds / 1000) / 3600
        val minutes = (milliseconds / 1000 % 3600) / 60
        val seconds = (milliseconds / 1000) % 60
        val millis = (milliseconds % 1000) / 10
        return "%02d:%02d:%02d:%02d".format(hours, minutes, seconds, millis)
    }

    fun resetStopwatch() {
        isRunning.value = false
        timeInMillis.longValue = 0L
        lapTimes.value = emptyList()
    }
}