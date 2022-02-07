import ru.dimagor555.parilka.Deps
import ru.dimagor555.parilka.androidDependencies
import ru.dimagor555.parilka.commonDependencies
import ru.dimagor555.parilka.iosDependencies

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("convention.plugin")
}

conventions {
    multiplatform()
    androidLib()
}

kotlin {
    commonDependencies {
        implementation(projects.bathFeature.usecase)

        implementation(Deps.Ktor.core)
        implementation(Deps.Ktor.json)
        implementation(Deps.Koin.core)

        implementation(Deps.multiSettings)
    }

    androidDependencies {
        implementation(Deps.Ktor.android)
        implementation(Deps.Koin.android)
    }

    iosDependencies {
        implementation(Deps.Ktor.ios)
    }
}