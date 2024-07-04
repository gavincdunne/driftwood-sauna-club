package com.weekendware.driftwood

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

class DriftwoodApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@DriftwoodApplication)
        }
    }
}