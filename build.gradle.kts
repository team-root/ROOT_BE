plugins {

    // Java
    kotlin("jvm") version PluginVersions.JVM_VERSION

    // Spring
    kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION

    // Gradle
    id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION

    // jpa
    kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION

    // lint
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
    implementation(DependencyNames.SPRING_DATA_JPA)

    // redis
    implementation(DependencyNames.REDIS)

    // Security
    implementation(DependencyNames.SECURITY)

    // Spring Web
    implementation(DependencyNames.SPRING_WEB)
    implementation(DependencyNames.SPRING_VALIDATION)

    // Kotlin
    implementation(DependencyNames.JACKSON)
    implementation(DependencyNames.KOTLIN_REFLECT)

    // feign
    implementation(DependencyNames.OPEN_FEIGN)
    implementation(DependencyNames.FEIGN_HTTP)

    // jwt
    implementation(DependencyNames.JWT_API)
    runtimeOnly(DependencyNames.JWT_IMPL)
    runtimeOnly(DependencyNames.JWT_JACKSON)

    // firebase
    implementation(DependencyNames.FIREBASE)

    // okhttp3
    implementation(DependencyNames.OKHTTP3)

    // mysql
    runtimeOnly("com.mysql:mysql-connector-j")

    // test
    testImplementation(DependencyNames.SPRING_TEST)
    testImplementation(DependencyNames.JUNIT5)
    testImplementation(DependencyNames.SPRING_SECURITY_TEST)
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
