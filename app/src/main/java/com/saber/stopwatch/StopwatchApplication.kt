package com.saber.stopwatch

import android.app.Application
import com.saber.stopwatch.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class StopwatchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@StopwatchApplication)
            modules(appModule)
        }
    }
}