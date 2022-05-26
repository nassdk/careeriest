package configuration

import config.Deps
import org.gradle.api.Project

internal class DependenciesConfigurator : ProjectConfigurator {

    override fun configure(project: Project) = with(project) {

        implementDependency(dependency = Deps.appCompat)
        implementDependency(dependency = Deps.coreKtx)
        implementDependency(dependency = Deps.fragment)
        implementDependency(dependency = Deps.lifeCViewModel)
        implementDependency(dependency = Deps.lifeCRuntime)
        implementDependency(dependency = Deps.timber)
        implementDependency(dependency = Deps.coroutinesAndroid)
        implementDependency(dependency = Deps.coroutinesCore)

        implementDependency(dependency = Deps.Network.retrofit)
        implementDependency(dependency = Deps.Network.serializationJson)

        implementDependency(dependency = Deps.Compose.ui)
        implementDependency(dependency = Deps.Compose.tooling)
        implementDependency(dependency = Deps.Compose.toolingPreview)
        implementDependency(dependency = Deps.Compose.foundation)
        implementDependency(dependency = Deps.Compose.material)
        implementDependency(dependency = Deps.Compose.constraint)
        implementDependency(dependency = Deps.Compose.coil)

        implementDependency(dependency = Deps.dagger)
        kapt(dependency = Deps.daggerCompiler)

        implementModule(modulePath = ":core:ui")
        implementModule(modulePath = ":core:common")
        implementModule(modulePath = ":core:navigation")
        implementModule(modulePath = ":core:network")
        implementModule(modulePath = ":core:di")
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