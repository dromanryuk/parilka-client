plugins {
    id("com.android.application")
    kotlin("android")
    id("convention.plugin")
}

conventions {
    androidApp()
    compose(isMultiplatform = false)
}

dependencies {
    implementation(projects.shared)
    implementation(projects.bathFeature.data)
}