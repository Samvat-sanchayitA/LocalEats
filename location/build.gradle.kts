import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.samvat.location"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        val localProperties = Properties().apply {
            val localPropertiesFile = rootProject.file("local.properties")
            if (localPropertiesFile.exists()) {
                localPropertiesFile.inputStream().use { load(it) }
            }
        }
        buildConfigField("String", "GOOGLE_MAPS_API_KEY", "\"${localProperties["GOOGLE_MAPS_API_KEY"]}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":common"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Jetpack Navigation
    implementation(Libraries.JetpackNavigation.navigationFragmentKtx)
    implementation(Libraries.JetpackNavigation.navigationUiKtx)
    implementation(Libraries.JetpackNavigation.navigationDynamicFeaturesFragment)


    // Jetpack Compose Navigation
    implementation(Libraries.JetpackNavigation.navigationUiKtx)
    implementation(Deps.navigationCompose)

    //Hilt
    implementation(Libraries.Hilt.hiltAndroid)
    ksp(Libraries.Hilt.hiltAndroidCompiler)

    // Google Maps
    implementation(Libraries.GoogleMaps.maps)
    implementation(Libraries.GoogleMaps.location)
    implementation(Libraries.GoogleMaps.places)
    implementation(Libraries.GoogleMaps.mapsUtils)
    implementation(libs.play.services.places)

    //Coroutines
    implementation(Libraries.Coroutines.core)
    implementation(Libraries.Coroutines.android)

    implementation(libs.accompanist.permissions)
    implementation(libs.material3)
    implementation (libs.androidx.constraintlayout.compose)
    implementation(libs.androidx.hilt.navigation.compose)
}