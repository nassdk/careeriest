pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "careeriest"

include(":app")
include(":core")
include(":core:ui")
include(":feature")
include(":feature:splash")
include(":core:common")
include(":core:network")
include(":benchmark")
