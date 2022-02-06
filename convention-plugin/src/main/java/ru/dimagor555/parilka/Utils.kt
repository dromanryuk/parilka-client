package ru.dimagor555.parilka

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

internal inline fun <reified T : Any> ExtensionContainer.with(block: T.() -> Unit) {
    getByType<T>().apply(block)
}

internal val ExtensionContainer.appOrLibraryExtension: CommonExtension<*, *, *, *>
    get() = findByType<ApplicationExtension>()
        ?: findByType<LibraryExtension>()
        ?: error("No app or library extension")

internal inline fun Project.kotlin(block: KotlinMultiplatformExtension.() -> Unit) {
    extensions.with(block)
}

fun KotlinMultiplatformExtension.commonDependencies(configure: KotlinDependencyHandler.() -> Unit) {
    dependencies("commonMain", configure)
}

fun KotlinMultiplatformExtension.androidDependencies(configure: KotlinDependencyHandler.() -> Unit) {
    dependencies("androidMain", configure)
}

fun KotlinMultiplatformExtension.iosDependencies(configure: KotlinDependencyHandler.() -> Unit) {
    dependencies("iosMain", configure)
}

private fun KotlinMultiplatformExtension.dependencies(
    sourceSetName: String,
    configure: KotlinDependencyHandler.() -> Unit
) {
    sourceSets.apply {
        named(sourceSetName) {
            dependencies(configure)
        }
    }
}

internal fun Project.androidDependencies(isMultiplatform: Boolean, dependencies: List<Any>) {
    if (isMultiplatform) {
        kotlin {
            androidDependencies {
                dependencies.forEach(::implementation)
            }
        }
    } else {
        dependencies {
            dependencies.forEach(::implementation)
        }
    }
}

internal fun DependencyHandler.implementation(dependencyNotation: Any) =
    add("implementation", dependencyNotation)

internal fun DependencyHandler.coreLibraryDesugaring(dependencyNotation: Any) =
    add("coreLibraryDesugaring", dependencyNotation)