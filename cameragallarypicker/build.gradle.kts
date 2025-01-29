@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id(libs.plugins.mavenPublish.get().pluginId)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}
publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.anuj-yash"
            artifactId = "cameragallarypicker"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}



android {
    namespace = "com.anuj.cameragallarypicker"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)        // << --- ADD This
        }
    }
//===============================

    java {
        sourceCompatibility = JavaVersion.VERSION_17            // << --- ADD This
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
//publishing {
//    publications {
//        maven(MavenPublication) {
//            groupId = 'com.github.geek-atif'
//            artifactId = 'com-atifqamar-customtoast'
//            version = "1.0"
//            pom {
//                description = 'First release'
//            }
//        }
//    }
//    repositories {
//        mavenLocal()
//    }
//}
