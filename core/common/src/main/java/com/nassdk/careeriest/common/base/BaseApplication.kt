package com.nassdk.careeriest.common.base

import android.app.Application
import com.nassdk.careeriest.common.di.DaggerBaseComponent

abstract class BaseApplication : Application() {

    companion object {
        lateinit var app: BaseApplication
    }

    init {
        app = this
    }

    val baseComponent by lazy {
        DaggerBaseComponent.factory().create(context = this)
    }
}