import ru.dimagor555.parilka.Deps

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
    implementation(projects.bathFeature.usecase)

    implementation(Deps.MviCompose.core)
    implementation(Deps.MviCompose.android)
}