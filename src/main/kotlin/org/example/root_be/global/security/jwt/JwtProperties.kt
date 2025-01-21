package org.example.root_be.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JwtProperties {
    var header: String = ""
    var prefix: String = ""
    var secret: String = ""
    var accessExpiration: Long = 0
    var refreshExpiration: Long = 0
}