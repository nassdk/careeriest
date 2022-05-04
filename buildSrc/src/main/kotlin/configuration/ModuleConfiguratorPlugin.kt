package configuration

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate

internal class ModuleConfiguratorPlugin : Plugin<Project> {

    private val featureModuleConfigurators by lazy {
        arrayOf(
            AndroidFeatureModuleConfigurator(),
            DependenciesConfigurator()
        )
    }

    override fun apply(target: Project) {

        target.logger.debug("Configuring ${target.name} module")

        if (target.name !in ignoreModules) {
            configureFeatureModule(project = target)
        }
    }

    private fun configureFeatureModule(project: Project) {

        featureModuleConfigurators.forEach { configurator ->
            configurator.configure(project = project)
        }
    }

    private companion object {
        private val ignoreModules = arrayOf("careeriest", "app", "buildSrc")
    }
}