    package org.example.root_be.global.security.jwt

    import io.jsonwebtoken.Claims
    import io.jsonwebtoken.Jwts
    import io.jsonwebtoken.security.Keys
    import jakarta.servlet.http.HttpServletRequest
    import org.example.root_be.global.security.auth.AuthDetailsService
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
    import org.springframework.stereotype.Component
    import java.util.*
    import javax.crypto.SecretKey

    @Component
    class JwtTokenProvider(
        private val jwtProperties: JwtProperties,
        private val authDetailsService: AuthDetailsService,
    ) {
        private val key: SecretKey = Keys.hmacShaKeyFor(
            jwtProperties.secret.toByteArray()
        )

        fun generateAccessToken(id: Long): String =
            generateToken(id, "access", jwtProperties.accessExpiration)

        fun generateRefreshToken(id: Long): String =
            generateToken(id, "refresh", jwtProperties.refreshExpiration)

        private fun generateToken(id: Long, type: String, expiration: Long): String =
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
            val userDetails = authDetailsService.loadUserByUsername(
                extractId(token).toString()
            )
            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }

        fun extractId(token: String): Long =
            getTokenBody(token).subject.toLong()
    }