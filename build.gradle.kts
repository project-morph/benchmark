plugins {
    kotlin("jvm") version "2.1.10"
}

group = "dev.codemorph"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.getunleash:unleash-client-java:10.2.2")

    testImplementation("io.github.java-diff-utils:java-diff-utils:4.15")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
