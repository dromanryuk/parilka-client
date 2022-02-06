import ru.dimagor555.parilka.Deps
import ru.dimagor555.parilka.commonDependencies

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
        api("ru.dimagor555.parilka.bath:domain:1.0.0")

        api(Deps.KotlinX.coroutinesCore)
    }
}