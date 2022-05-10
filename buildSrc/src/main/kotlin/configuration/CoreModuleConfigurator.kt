package configuration

import com.android.build.gradle.BaseExtension
import config.Config
import config.Plugins
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal class CoreModuleConfigurator : ProjectConfigurator {

    override fun configure(project: Project) = with(project) {
        configurePlugins()
        configureAndroidSettings()
    }

    private fun Project.configurePlugins() = with(plugins) {
        apply(Plugins.android)
        apply(Plugins.ktAndroid)
        apply(Plugins.kapt)
    }

    private fun Project.configureAndroidSettings() {

        (extensions.getByName("android") as? BaseExtension)?.apply {
            configureDefaultConfig(moduleName = name)
            configureCompileOptions()
            configureKotlinOptions()
        } ?: project.logger.error("Failed to configure android settings for $name module")
    }

    private fun BaseExtension.configureDefaultConfig(moduleName: String) {

        namespace = "${Config.applicationId}.$moduleName"
        compileSdkVersion(apiLevel = Config.compileSdkVersion)

        defaultConfig {
            minSdk = Config.minSdkVersion
            targetSdk = Config.targetSdkVersion

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }
    }

    private fun BaseExtension.configureCompileOptions() {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    private fun Project.configureKotlinOptions() {
        tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}