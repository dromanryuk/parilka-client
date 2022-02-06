package ru.dimagor555.parilka

import org.gradle.api.Project

internal fun Project.composeConvention() {
    extensions.appOrLibraryExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Deps.Compose.version
        }
    }
}

internal val composeDependencies = listOf(
    Deps.Compose.activity,
    Deps.Compose.ui,
    Deps.Compose.tooling,
    Deps.Compose.material,
    Deps.Compose.iconsExtended,

    Deps.Accompanist.navigationAnimation,
    Deps.Accompanist.glide,
    Deps.Accompanist.flowLayout
)