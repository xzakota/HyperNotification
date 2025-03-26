@file:Suppress("UnstableApiUsage")

import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    kotlin("android")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.vanniktech.maven.publish)
}

group = "com.xzakota.hyper.notification"
version = "1.0"

android {
    namespace = "com.xzakota.hyper.notification.focus"
    compileSdk = 36
    buildToolsVersion = "36.0.0"

    defaultConfig {
        minSdk = 33
    }

    buildFeatures {
        androidResources = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.majorVersion
    }

    testOptions.unitTests.all {
        it.useJUnitPlatform()
    }
}

mavenPublishing {
    configureBasedOnAppliedPlugins(javadocJar = true)

    coordinates(group.toString(), name, version.toString())

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
}

dependencies {
    implementation(libs.kotlinx.serialization.json)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
}
