package com.nassdk.careeriest

import com.nassdk.careeriest.common.base.BaseApplication
import com.nassdk.careeriest.di.DaggerAppComponent
import timber.log.Timber

class AppDelegate : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
        initTimber()
    }

    private fun initAppComponent() {
        AppComponentHolder.init(baseComponent = baseComponent)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}