@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/gradle-plugin/")
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://maven.aliyun.com/repository/google/")

        mavenLocal()
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://maven.aliyun.com/repository/google/")

        mavenLocal()
        google()
        mavenCentral()
    }
}

rootProject.name = "HyperNotification"
include(
    ":focus-api",
    ":example"
)
