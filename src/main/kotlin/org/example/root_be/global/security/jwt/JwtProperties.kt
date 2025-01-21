package org.example.root_be.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    val header: String,
    val prefix: String,
    val secret: String,
    val accessExpiration: Long,
    val refreshExpiration: Long
)