package com.nassdk.careeriest.di

fun interface ModuleDependencyProvider<out T> {
    fun getDependencies(): T
}