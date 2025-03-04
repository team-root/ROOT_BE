package org.example.rootbe.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
data class JwtProperties(
    val header: String = "",
    val prefix: String = "",
    val secret: String = "",
    val accessExpiration: Long = 0,
    val refreshExpiration: Long = 0,
)
