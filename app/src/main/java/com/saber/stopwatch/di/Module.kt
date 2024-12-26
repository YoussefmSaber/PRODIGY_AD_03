package com.saber.stopwatch.di

import com.saber.stopwatch.viewmodel.StopwatchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { StopwatchViewModel() }
}