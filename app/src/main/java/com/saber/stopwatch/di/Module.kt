package com.saber.stopwatch.di

import com.saber.stopwatch.viewmodel.StopwatchViewModel
import org.koin.dsl.module

val appModule = module {

    single { StopwatchViewModel() }
}