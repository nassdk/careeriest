plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("com.careeriest.app.module-configurator") {
            id = "com.careeriest.app.module-configurator"
            implementationClass = "configuration.ModuleConfiguratorPlugin"
        }
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(dependencyNotation = "com.android.tools.build:gradle:7.1.2")
    implementation(dependencyNotation = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}
