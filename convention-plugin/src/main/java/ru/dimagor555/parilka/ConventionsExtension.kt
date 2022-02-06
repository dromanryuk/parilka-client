package ru.dimagor555.parilka

import org.gradle.api.Project
import kotlin.properties.Delegates

open class ConventionsExtension {
    internal var project: Project by Delegates.notNull()

    fun multiplatform() {
        project.multiplatformConvention()
        project.androidMultiplatformConvention()
    }

    fun androidApp() {
        project.androidCommonConvention()
        project.androidDependencies(isMultiplatform = false, androidCommonDependencies)
        project.androidAppConvention()
        project.androidAppDependencies()
    }

    fun androidLib(isMultiplatform: Boolean = true) {
        project.androidCommonConvention()
        project.androidDependencies(isMultiplatform, androidCommonDependencies)
    }

    fun compose(isMultiplatform: Boolean = true) {
        project.composeConvention()
        project.androidDependencies(isMultiplatform, composeDependencies)
    }
}