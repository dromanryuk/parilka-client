plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "ru.dimagor555.parilka.android"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha02"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")

    //Compose
    implementation("androidx.compose.ui:ui:1.2.0-alpha02")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.0-alpha02")
    implementation("androidx.compose.material:material:1.2.0-alpha02")
    implementation("androidx.compose.animation:animation:1.2.0-alpha02")
    implementation("androidx.compose.material:material-icons-extended:1.2.0-alpha02")
    implementation("androidx.activity:activity-compose:1.4.0")

    //Ktx
    implementation("androidx.core:core-ktx:1.7.0")

    //Accompanist
    implementation("com.google.accompanist:accompanist-navigation-animation:0.24.1-alpha")
    implementation("com.google.accompanist:accompanist-insets:0.17.0")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")
    implementation("com.google.accompanist:accompanist-glide:0.10.0")
    implementation("com.google.accompanist:accompanist-flowlayout:0.24.1-alpha")
}