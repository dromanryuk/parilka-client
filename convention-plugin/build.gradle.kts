plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    compileOnly("com.android.tools.build:gradle:7.1.0")
}

gradlePlugin {
    plugins.create(project.name) {
        id = "convention.plugin"
        implementationClass = "ru.dimagor555.parilka.ConventionPlugin"
    }
}
