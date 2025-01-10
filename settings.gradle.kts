rootProject.name = "concurrency"

include ("concurrency-taxi-tracker")
include ("concurrency-basics")
include ("concurrency-utils")
include ("concurrency-collections")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

