package com.nassdk.careeriest

import android.content.Context
import com.nassdk.careeriest.di.AppComponent
import com.nassdk.careeriest.di.DaggerAppComponent

object AppComponentHolder {

    lateinit var component: AppComponent
        private set

    fun init(context: Context) {
        component = DaggerAppComponent.factory()
            .create(context = context)
    }
}