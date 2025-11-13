import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "com.eviltester"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // add logging https://github.com/oshai/kotlin-logging
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.3")
    // logging for stdout
    implementation("org.slf4j:slf4j-simple:2.0.3")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.6.3")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}