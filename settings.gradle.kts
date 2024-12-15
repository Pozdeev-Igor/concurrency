rootProject.name = "concurrency"

include ("concurrency-taxi-tracker")
include ("concurrency-basics")
include ("concurrency-utils")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

