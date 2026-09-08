plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    id("androidx.room") version "2.7.0-alpha11"
}

room {
    schemaDirectory("$projectDir/schemas")
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }
    }




    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlin.stdlib)
            implementation("androidx.room:room-runtime:2.7.0-alpha11")
            implementation("androidx.sqlite:sqlite-bundled:2.5.0-alpha11")
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            // Add Android-specific dependencies here.
        }

        androidUnitTest.dependencies {
            implementation(libs.junit)
        }

        androidInstrumentedTest.dependencies {
            implementation(libs.androidx.core)
            implementation(libs.androidx.junit)
            implementation(libs.androidx.runner)
        }

        iosMain.dependencies {
            // Add iOS-specific dependencies here.
        }
    }
}

android {
    namespace = "com.localdatabase"
    compileSdk = 37

    defaultConfig {
        minSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    add("kspCommonMainMetadata", "androidx.room:room-compiler:2.7.0-alpha11")
    ksp("androidx.room:room-compiler:2.7.0-alpha11")
}