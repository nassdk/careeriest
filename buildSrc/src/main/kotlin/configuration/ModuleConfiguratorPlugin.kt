package configuration

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate

internal class ModuleConfiguratorPlugin : Plugin<Project> {

    private val featureModuleConfigurators by lazy {
        arrayOf(
            FeatureModuleConfigurator(),
            DependenciesConfigurator()
        )
    }

    private val coreModulesConfigurator by lazy {
        arrayOf(CoreModuleConfigurator())
    }

    override fun apply(target: Project) = with(target) {

        target.logger.debug("Configuring $name module")

        when (name) {
            in ignoreModules      -> return
            in coreAndroidModules -> configureCoreAndroidModule()
            else                  -> configureFeatureModule()
        }
    }

    private fun Project.configureFeatureModule() {

        featureModuleConfigurators.forEach { configurator ->
            configurator.configure(project = this)
        }
    }

    private fun Project.configureCoreAndroidModule() {

        coreModulesConfigurator.forEach { configurator ->
            configurator.configure(project = this)
        }
    }

    private companion object {
        private val ignoreModules = arrayOf("careeriest", "app", "buildSrc", "core", "feature", "benchmark")
        private val coreAndroidModules = arrayOf("ui", "common", "network", "navigation")
    }
}