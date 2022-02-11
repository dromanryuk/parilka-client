package ru.dimagor555.parilka

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.androidAppConvention() {
    extensions.with<ApplicationExtension> {
        defaultConfig {
            applicationId = AndroidConfig.appId
            versionCode = AndroidConfig.versionCode
            versionName = AndroidConfig.versionName
        }

        buildTypes {
            release {
                isMinifyEnabled = true
                isShrinkResources = true

                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
        }
    }
}

internal fun Project.androidAppDependencies() {
    dependencies {
        implementation(Deps.AndroidX.splashScreen)

        implementation(Deps.Koin.core)
        implementation(Deps.Koin.android)
        implementation(Deps.Koin.compose)

        coreLibraryDesugaring(Deps.jdkDesugar)
    }
}