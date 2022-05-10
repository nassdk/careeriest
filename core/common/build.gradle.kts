android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = config.Version.composeCore
    }
}

dependencies {
    implementation(dependencyNotation = config.Deps.Compose.ui)
    implementation(dependencyNotation = config.Deps.Compose.foundation)
    implementation(dependencyNotation = config.Deps.Compose.material)
    implementation(dependencyNotation = config.Deps.fragment)
    implementation(dependencyNotation = config.Deps.coroutinesCore)
    implementation(dependencyNotation = config.Deps.coroutinesAndroid)
    implementation(dependencyNotation = config.Deps.lifeCRuntime)
    implementation(dependencyNotation = config.Deps.lifeCViewModel)
    implementation(dependencyNotation = config.Deps.dataStore)
    implementation(dependencyNotation = config.Deps.dagger)
    kapt(dependencyNotation = config.Deps.daggerCompiler)

    implementation(dependencyNotation = project(path = ":core:ui"))
    implementation(dependencyNotation = project(path = ":core:network"))
}