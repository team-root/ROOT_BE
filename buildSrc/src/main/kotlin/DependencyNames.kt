object DependencyNames {

    // kotlin
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    // starter
    private const val STARTER = "org.springframework.boot:spring-boot-starter"

    // web
    const val SPRING_WEB = "$STARTER-web"

    // validation
    const val SPRING_VALIDATION = "$STARTER-validation"

    // jpa
    const val SPRING_DATA_JPA = "$STARTER-data-jpa"

    // redis
    const val REDIS = "$STARTER-data-redis"

    // mysql
    const val MYSQL = "com.mysql:mysql-connector-j"

    // security
    const val SECURITY = "$STARTER-security"

    // feign
    const val OPEN_FEIGN = "org.springframework.cloud:spring-cloud-starter-openfeign"
    const val FEIGN_HTTP = "io.github.openfeign:feign-httpclient:13.5"

    // jwt
    const val JWT_API = "io.jsonwebtoken:jjwt-api:${DependencyVersion.JWT_VERSION}"
    const val JWT_JACKSON = "io.jsonwebtoken:jjwt-jackson:${DependencyVersion.JWT_VERSION}"
    const val JWT_IMPL = "io.jsonwebtoken:jjwt-impl:${DependencyVersion.JWT_VERSION}"

    // firebase
    const val FIREBASE = "com.google.firebase:firebase-admin:${DependencyVersion.FIREBASE_VERSION}"

    // okhttp3
    const val OKHTTP3 = "com.squareup.okhttp3:okhttp:${DependencyVersion.OKHTTP3_VERSION}"

    // hwpLib
    const val HWP = "kr.dogfoot:hwplib:${DependencyVersion.HWP_LIB_VERSION}"

    // poi
    const val POI_OOXML = "org.apache.poi:poi-ooxml:${DependencyVersion.POI_VERSION}"

    // commons io
    const val COMMONS_IO = "commons-io:commons-io:${DependencyVersion.COMMONS_IO}"

    // test
    const val SPRING_TEST = "$STARTER-test"
    const val JUNIT5 = "org.jetbrains.kotlin:kotlin-test-junit5"
    const val SPRING_SECURITY_TEST = "org.jetbrains.kotlin:kotlin-test-junit5"

    const val JUNIT_LAUNCHER = "org.junit.platform:junit-platform-launcher"
}