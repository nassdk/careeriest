package configuration

import config.Deps
import org.gradle.api.Project

internal class DependenciesConfigurator : ProjectConfigurator {

    override fun configure(project: Project) = with(project) {
        implementDependency(dependency = Deps.appCompat)
        implementDependency(dependency = Deps.coreKtx)
        implementDependency(dependency = Deps.fragment)
        implementDependency(dependency = Deps.lifecycleViewModel)
        implementDependency(dependency = Deps.lifecycleRuntime)
        implementDependency(dependency = Deps.retrofit)
        implementDependency(dependency = Deps.okhttp)
        implementDependency(dependency = Deps.okhttpLogging)
        implementDependency(dependency = Deps.serializationConverter)
        implementDependency(dependency = Deps.serializationJson)
        implementDependency(dependency = Deps.timber)
        implementDependency(dependency = Deps.dagger)
        kapt(dependency = Deps.daggerCompiler)
    }

    private fun Project.implementModule(modulePath: String) {
        dependencies.add("implementation", project(modulePath))
    }

    private fun Project.implementDependency(dependency: String) {
        dependencies.add("implementation", dependency)
    }

    private fun Project.kapt(dependency: String) {
        dependencies.add("kapt", dependency)
    }
}