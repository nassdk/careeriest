package configuration

import com.android.build.gradle.BaseExtension
import config.Config
import config.Plugins
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal class AndroidFeatureModuleConfigurator : ProjectConfigurator {

    override fun configure(project: Project) = with(project) {
        configurePlugins()
        configureAndroidSettings()
    }

    private fun Project.configurePlugins() = with(plugins) {
        apply(Plugins.android)
        apply(Plugins.ktAndroid)
        apply(Plugins.parcelize)
        apply(Plugins.kapt)
    }

    private fun Project.configureAndroidSettings() {
        val androidExtension = extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(apiLevel = Config.compileSdkVersion)
                buildToolsVersion(version = Config.buildToolsVersion)
                defaultConfigConfiguration()
                compileOptionsConfigurator()
                kotlinOptionsConfigurator(project = project)
                buildFeaturesConfigurator()
            }
        } else {
            project.logger.error("Failed to configure android settings for ${project.name} module")
        }
    }

    private fun BaseExtension.defaultConfigConfiguration() {
        defaultConfig {
            minSdk = Config.minSdkVersion
            targetSdk = Config.targetSdkVersion
            versionName = Config.versionName
            versionCode = Config.versionCode

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }
    }

    private fun BaseExtension.compileOptionsConfigurator() {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    private fun kotlinOptionsConfigurator(project: Project) {
        project.tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    private fun BaseExtension.buildFeaturesConfigurator() {
        buildFeatures.compose = true
    }
}