package org.example.root_be.global.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.example.root_be.global.security.auth.AuthDetailsService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter(
    private val jwtTokenProperties: JwtProperties,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authDetailsService: AuthDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = extractToken(request)
        
        if (!token.isNullOrBlank()) {
            val userDetails = authDetailsService.loadUserByUsername(
                jwtTokenProvider.extractId(token).toString()
            )
            SecurityContextHolder.getContext().authentication =
                UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }

        filterChain.doFilter(request, response)
    }

    private fun extractToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(jwtTokenProperties.header)
        return if (bearerToken != null && bearerToken.startsWith(jwtTokenProperties.prefix + " ")) {
            bearerToken.substring(7)
        } else null
    }
}
