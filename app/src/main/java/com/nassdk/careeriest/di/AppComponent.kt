package com.nassdk.careeriest.di

import com.nassdk.careeriest.AppActivity
import com.nassdk.careeriest.common.di.BaseComponent
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [BaseComponent::class])
@AppScope
interface AppComponent : BaseComponent {

    @Component.Factory
    interface Factory {
        fun create(baseComponent: BaseComponent): AppComponent
    }

    fun inject(activity: AppActivity)
}