pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "parilka-client"

includeBuild("convention-plugin")

include(":androidApp")
include(":shared")
include(
    "bath-feature",
    ":bath-feature:usecase",
    ":bath-feature:data"
)
