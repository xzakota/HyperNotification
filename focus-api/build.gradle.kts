@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    kotlin("android")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.vanniktech.maven.publish)
}

group = "com.xzakota.hyper.notification"
version = "1.3"

android {
    namespace = "com.xzakota.hyper.notification.focus"
    compileSdk = 36
    buildToolsVersion = "36.0.0"

    defaultConfig {
        minSdk = 27
    }

    androidResources {
        enable = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    testOptions.unitTests.all {
        it.useJUnitPlatform()
    }
}

kotlin {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_21)
}

mavenPublishing {
    configureBasedOnAppliedPlugins(javadocJar = true)

    coordinates(group.toString(), name, version.toString())

    publishToMavenCentral(true)
    signAllPublications()
}

dependencies {
    implementation(libs.kotlinx.serialization.json)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.laucher)
}
