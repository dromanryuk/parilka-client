package ru.dimagor555.parilka

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class ConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create<ConventionsExtension>("conventions").project = target
    }
}