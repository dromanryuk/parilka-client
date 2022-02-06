package ru.dimagor555.parilka

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal fun Project.androidCommonConvention() {
    extensions.with<BaseExtension> {
        compileSdkVersion(AndroidConfig.compileSdk)

        defaultConfig {
            minSdk = AndroidConfig.minSdk
            targetSdk = AndroidConfig.targetSdk
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        packagingOptions {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}

internal val androidCommonDependencies = listOf(
    Deps.AndroidX.coreKtx,
    Deps.AndroidX.appCompat
)