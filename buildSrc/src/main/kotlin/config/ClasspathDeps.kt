package config

object ClasspathDeps {
    const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
}