package ru.dimagor555.parilka

object Deps {
    const val jdkDesugar = "com.android.tools:desugar_jdk_libs:1.1.5"

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"

        const val splashScreen = "androidx.core:core-splashscreen:1.0.0-alpha01"
    }

    object Compose {
        const val version = "1.1.0-rc03"

        const val activity = "androidx.activity:activity-compose:1.4.0"
        const val ui = "androidx.compose.ui:ui:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val material = "androidx.compose.material:material:$version"
        const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
    }

    object Accompanist {
        const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:0.24.1-alpha"
        const val glide = "com.google.accompanist:accompanist-glide:0.10.0"
        const val flowLayout = "com.google.accompanist:accompanist-flowlayout:0.24.1-alpha"
    }

    object KotlinX {
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:0.3.0"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
    }

    object Ktor {
        private const val version = "1.6.7"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-serialization:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
    }

    object Koin {
        private const val version = "3.1.5"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }
}