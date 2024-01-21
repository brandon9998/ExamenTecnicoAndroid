pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        //libreria

    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

       
    }
}

rootProject.name = "Examentecnico"
include(":app")
