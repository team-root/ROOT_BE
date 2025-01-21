package org.example.root_be.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.root_be.global.err.GlobalExceptionFilter
import org.example.root_be.global.security.auth.AuthDetailsService
import org.example.root_be.global.security.jwt.JwtFilter
import org.example.root_be.global.security.jwt.JwtProperties
import org.example.root_be.global.security.jwt.JwtTokenProvider
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class FilterConfig(
    private val objectMapper: ObjectMapper,
    private val jwtProperties: JwtProperties,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authDetailsService: AuthDetailsService
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(JwtFilter(jwtProperties, jwtTokenProvider, authDetailsService), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(GlobalExceptionFilter(objectMapper), JwtFilter::class.java)
    }
}
