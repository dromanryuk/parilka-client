package ru.dimagor555.parilka

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.multiplatformConvention() {
    extensions.with<KotlinMultiplatformExtension> {
        android()

        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach {
            it.binaries.framework {
                baseName = project.name
            }
        }

        sourceSets.apply {
            val commonMain = getByName("commonMain")

            val iosX64Main = getByName("iosX64Main")
            val iosArm64Main = getByName("iosArm64Main")
            val iosSimulatorArm64Main = getByName("iosSimulatorArm64Main")

            val iosMain = create("iosMain") {
                this.dependsOn(commonMain)
                iosX64Main.dependsOn(this)
                iosArm64Main.dependsOn(this)
                iosSimulatorArm64Main.dependsOn(this)
            }
        }
    }
}

internal fun Project.androidMultiplatformConvention() {
    extensions.with<BaseExtension> {
        sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    }
}