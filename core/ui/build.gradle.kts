android {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = config.Version.composeCore
    }
}

dependencies {
    implementation(dependencyNotation = config.Deps.Compose.material)
    implementation(dependencyNotation = config.Deps.Compose.ui)
    implementation(dependencyNotation = config.Deps.Compose.foundation)
    implementation(dependencyNotation = config.Deps.Compose.tooling)
}