object Libraries {
    object LibVersions {
        const val retrofit = "2.9.0"
        const val gson = "2.9.0"
        const val okhttp = "4.9.2"
        const val loggingInterceptor = "4.9.2"
        const val coroutines = "1.6.0"
        const val glide = "4.12.0"
        const val viewModel = "2.4.0"
        const val hilt = "2.51"
        const val googleMaps = "18.0.0"
        const val places = "2.7.0"
        const val mapsUtils = "3.2.0"
        const val mockito = "4.2.0"
        const val room = "2.4.0"
        const val lifecycle = "2.2.0"
        const val kotlin = "1.6.0"
        const val navigation = "2.4.0"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${LibVersions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${LibVersions.gson}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${LibVersions.okhttp}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${LibVersions.loggingInterceptor}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibVersions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibVersions.coroutines}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${LibVersions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${LibVersions.glide}"
    }

    object ViewModel {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibVersions.viewModel}"
    }

    object Hilt {
        const val hiltAndroid = "com.google.dagger:hilt-android:${LibVersions.hilt}" //
        const val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${LibVersions.hilt}" //
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${LibVersions.hilt}" //

    }

    object GoogleMaps {
        const val maps = "com.google.android.gms:play-services-maps:${LibVersions.googleMaps}"
        const val location =
            "com.google.android.gms:play-services-location:${LibVersions.googleMaps}"
        const val places = "com.google.android.libraries.places:places:${LibVersions.places}"
        const val mapsUtils = "com.google.maps.android:maps-utils-ktx:${LibVersions.mapsUtils}"
    }

    object Mockito {
        const val mockitoCore = "org.mockito:mockito-core:${LibVersions.mockito}"
        const val mockitoAndroid = "org.mockito:mockito-android:${LibVersions.mockito}"
    }

    object RoomDatabase {
        const val room = "androidx.room:room-runtime:${LibVersions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${LibVersions.room}"
        const val roomKtx = "androidx.room:room-ktx:${LibVersions.room}"
    }

    object MVVMLibs {
        const val lifecycleExtensions =
            "androidx.lifecycle:lifecycle-extensions:${LibVersions.lifecycle}"
        const val lifecycleViewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibVersions.lifecycle}"
        const val lifecycleLiveDataKtx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${LibVersions.lifecycle}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${LibVersions.lifecycle}"
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${LibVersions.kotlin}"
    }

    object JetpackNavigation {
        const val navigationFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${LibVersions.navigation}"
        const val navigationUiKtx =
            "androidx.navigation:navigation-ui-ktx:${LibVersions.navigation}"
        const val navigationDynamicFeaturesFragment =
            "androidx.navigation:navigation-dynamic-features-fragment:${LibVersions.navigation}"
    }

}

object Version {
    const val core = "1.12.0"
    const val junit = "4.13.2"
    const val appCompat = "1.6.1"
    const val androidMaterial = "1.11.0"
    const val androidTestImplementationJunit = "1.1.5"
    const val espresso = "3.5.1"
    const val composeBom = "2023.08.00"
    const val navigationCompose = "2.6.0-alpha05"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0"
    const val activityCompose = "androidx.activity:activity-compose:1.8.2"
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBom}"
    const val ui = "androidx.compose.ui:ui"
    const val uiGraphics = "androidx.compose.ui:ui-graphics"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3"
    const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Version.navigationCompose}"
}