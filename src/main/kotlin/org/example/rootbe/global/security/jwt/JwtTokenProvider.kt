package org.example.rootbe.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.example.rootbe.global.security.auth.AuthDetailsService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component
import java.util.Date
import javax.crypto.SecretKey

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
) {
    private val key: SecretKey =
        Keys.hmacShaKeyFor(
            jwtProperties.secret.toByteArray(),
        )

    companion object {
        private const val ACCESS_KEY = "access_token"
        private const val REFRESH_KEY = "refresh_token"
    }

    fun generateAccessToken(id: Long): String = generateToken(id, ACCESS_KEY, jwtProperties.accessExpiration)

    fun generateRefreshToken(id: Long): String = generateToken(id, REFRESH_KEY, jwtProperties.refreshExpiration)

    private fun generateToken(
        id: Long,
        type: String,
        expiration: Long,
    ): String =
        Jwts.builder()
            .setSubject(id.toString())
            .claim("type", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .signWith(key)
            .compact()

    fun getTokenBody(token: String): Claims =
        Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body

    fun resolveToken(request: HttpServletRequest): String? =
        request.getHeader(jwtProperties.header)?.also {
            if (it.startsWith(jwtProperties.prefix)) {
                return it.substring(jwtProperties.prefix.length)
            }
        }

    fun authentication(token: String): UsernamePasswordAuthenticationToken? {
        val userDetails = authDetailsService.loadUserByUsername(getTokenBody(token).subject)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }
}
