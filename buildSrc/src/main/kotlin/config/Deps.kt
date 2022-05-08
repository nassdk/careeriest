package config

object Deps {

    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val fragment = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"

    const val lifeCVMCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"
    const val lifeCViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifeCRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"

    const val dataStore = "androidx.datastore:datastore-preferences:${Version.dataStore}"

    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"

    const val dagger = "com.google.dagger:dagger:${Version.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"

    const val timber = "com.jakewharton.timber:timber:${Version.timber}"

    const val securityCrypto = "androidx.security:security-crypto:${Version.securityCrypto}"

    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
        const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
        const val serializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serializationJson}"
        const val serializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.serializationConverter}"
    }

    object Compose {
        const val activity = "androidx.activity:activity-compose:${Version.composeActivity}"
        const val ui = "androidx.compose.ui:ui:${Version.composeCore}"
        const val material = "androidx.compose.material:material:${Version.composeCore}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.composeCore}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Version.composeCore}"
        const val foundation = "androidx.compose.foundation:foundation:${Version.composeFoundation}"
        const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:${Version.systemUi}"
        const val coil = "io.coil-kt:coil-compose:${Version.coil}"
        const val constraint =
            "androidx.constraintlayout:constraintlayout-compose:${Version.constraint}"
    }

    object Test {
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Version.mockitoKotlin}"
        const val junit = "androidx.test.ext:junit:${Version.junit}"
        const val compose = "androidx.compose.ui:ui-test-junit4:${Version.composeCore}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    }
}
