plugins {
    id("com.github.ben-manes.versions").version("0.42.0")
}

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(dependencyNotation = config.ClasspathDeps.gradle)
        classpath(dependencyNotation = config.ClasspathDeps.kotlin)
        classpath(dependencyNotation = config.ClasspathDeps.serialization)
        classpath(dependencyNotation = config.ClasspathDeps.safeArgs)
    }
}

apply(plugin = config.Plugins.moduleConfigurator)

subprojects {
    apply(plugin = config.Plugins.moduleConfigurator)
}

project.tasks.register<Delete>("clean") {
    delete(project.rootProject.buildDir)
}