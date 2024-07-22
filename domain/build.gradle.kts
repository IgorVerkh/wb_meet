plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

dependencies {
    implementation(libs.koin.core)
    implementation(platform(libs.koin.bom))
    implementation(libs.kotlinx.coroutines.core)
}
