import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // hilt
    id("com.google.dagger.hilt.android")

    // kapt
    id("kotlin-kapt")

    // firebase
    id("com.google.gms.google-services")

    // parcelable
    id("kotlin-parcelize")
}

android {
    namespace = "com.pollyannawu.gogolook"
    compileSdk = 33

    defaultConfig {

        // api key in local properties
        val properties = Properties()
        properties.load(rootProject.file("local.properties").inputStream())
        buildConfigField("String", "API_KEY", "\"${properties.getProperty("API_KEY")}\"")


        applicationId = "com.pollyannawu.gogolook"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures{
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.5.0")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.fragment:fragment-ktx:1.3.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("com.google.ar.sceneform:filament-android:1.17.1")
    implementation("androidx.compose.material3:material3:1.1.2")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    // firebase for remote config
    implementation("com.google.firebase:firebase-config:21.6.0")
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore-ktx:24.9.1")

    // moshi
    val version_moshi = "1.14.0"
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$version_moshi")
    implementation ("com.squareup.moshi:moshi:$version_moshi")
    implementation ("com.squareup.moshi:moshi-kotlin:$version_moshi")

    // Glide
   val version_glide = "4.15.1"
    implementation ("com.github.bumptech.glide:glide:$version_glide")
    kapt ("com.github.bumptech.glide:compiler:$version_glide")


    // retrofit
    val version_retrofit = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$version_retrofit")
    implementation ("com.squareup.retrofit2:converter-moshi:$version_retrofit")


    // okHttp
    val version_okhttp = "4.9.1"
    implementation("com.squareup.okhttp3:okhttp:$version_okhttp")
    implementation ("com.squareup.okhttp3:logging-interceptor:$version_okhttp")
    testImplementation ("com.squareup.okhttp3:mockwebserver:$version_okhttp")
}