plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.tudominio.recyclervieweditdemo" // Cambia por tu paquete real
    compileSdk = 33

    defaultConfig {
        applicationId = "com.tudominio.recyclervieweditdemo" // Cambia por tu paquete real
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        // Si usas Java 8+ features
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true // Opcional, si usas ViewBinding
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Kotlin standard library (normalmente ya viene con el plugin)
    implementation(kotlin("stdlib"))
}