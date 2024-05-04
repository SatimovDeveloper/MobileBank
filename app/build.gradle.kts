plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "uz.gita.mobilebank"
    compileSdk = 34

    defaultConfig {
        applicationId = "uz.gita.mobilebank"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //voyager
    val voyagerVersion = "1.0.0"
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-hilt:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")
    implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
    // Screen Model == viewmodel
    implementation("cafe.adriel.voyager:voyager-screenmodel:$voyagerVersion")

    //dagger hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")

    //Mvi orbit
    implementation("org.orbit-mvi:orbit-viewmodel:4.6.1")
    implementation("org.orbit-mvi:orbit-compose:4.6.1")

    // kotlinx.coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation("androidx.compose.ui:ui:1.6.6")
    implementation("androidx.compose.material:material:1.6.6")

    //Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")

    //Json
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.10")

    //Rest Api
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    /**
     *  Chuck
     */
    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")
}