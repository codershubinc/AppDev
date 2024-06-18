// Root build.gradle.kts
plugins {
    // Do not include the com.android.application plugin here
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.application) apply false
}

allprojects {
    repositories {
// mavenCentral()
        //        google()
    //    mavenCentral()
    }
}
