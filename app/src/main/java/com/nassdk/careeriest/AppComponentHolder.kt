package com.nassdk.careeriest

import com.nassdk.careeriest.common.di.BaseComponent
import com.nassdk.careeriest.di.AppComponent
import com.nassdk.careeriest.di.DaggerAppComponent

object AppComponentHolder {

    fun init(baseComponent: BaseComponent) {
        component = DaggerAppComponent.factory().create(baseComponent = baseComponent)
    }

    lateinit var component: AppComponent
}