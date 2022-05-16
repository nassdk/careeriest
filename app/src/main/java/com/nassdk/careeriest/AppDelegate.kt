package com.nassdk.careeriest

import android.app.Application
import timber.log.Timber

class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
        initTimber()
    }

    private fun initAppComponent() {
        AppComponentHolder.init(context = this)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}