import config.Config
import config.Deps
import config.Version

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin(module = "kapt")
}

android {

    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
        }

        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = false
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCore
    }
}

dependencies {
    implementation(dependencyNotation = project(path = ":feature:splash"))
    implementation(dependencyNotation = project(path = ":core:ui"))
    implementation(dependencyNotation = project(path = ":core:common"))
    implementation(dependencyNotation = project(path = ":core:navigation"))

    implementation(dependencyNotation = Deps.fragment)
    implementation(dependencyNotation = Deps.navigationFragment)
    implementation(dependencyNotation = Deps.navigationUi)
    implementation(dependencyNotation = Deps.coreKtx)
    implementation(dependencyNotation = Deps.appCompat)
    implementation(dependencyNotation = Deps.timber)

    implementation(dependencyNotation = Deps.Compose.material)
    implementation(dependencyNotation = Deps.Compose.activity)

    implementation(dependencyNotation = Deps.dagger)
    kapt(dependencyNotation = Deps.daggerCompiler)
}