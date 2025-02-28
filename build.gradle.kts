plugins {
    kotlin("jvm") version PluginVersions.JVM_VERSION
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
    id("org.jlleitschuh.gradle.ktlint") version PluginVersions.KLINT_VERSION
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // Security
    implementation("org.springframework.boot:spring-boot-starter-security")

    // Spring Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // feign
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-httpclient:13.5")

    // jwt
    implementation("io.jsonwebtoken:jjwt-api:${DependencyVersion.JWT_VERSION}")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:${DependencyVersion.JWT_VERSION}")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:${DependencyVersion.JWT_VERSION}")

    // firebase
    implementation("com.google.firebase:firebase-admin:${DependencyVersion.FIREBASE_VERSION}")

    // okhttp3
    implementation("com.squareup.okhttp3:okhttp:${DependencyVersion.OKHTTP3_VERSION}")

    // mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${DependencyVersion.SPRING_CLOUD_VERSION}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
