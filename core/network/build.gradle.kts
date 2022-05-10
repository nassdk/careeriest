import config.Deps

android {

    defaultConfig {
        buildConfigField(type = "String", name = "BASE_URL", value = "\"https://www.google.com\"")
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(dependencyNotation = Deps.Network.okhttp)
    implementation(dependencyNotation = Deps.Network.okhttpLogging)
    implementation(dependencyNotation = Deps.Network.retrofit)
    implementation(dependencyNotation = Deps.Network.serializationJson)
    implementation(dependencyNotation = Deps.Network.serializationConverter)

    implementation(dependencyNotation = Deps.dagger)
    kapt(dependencyNotation = Deps.daggerCompiler)
}