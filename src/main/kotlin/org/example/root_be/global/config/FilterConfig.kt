package org.example.root_be.global.config

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
    private val jwtProperties: JwtProperties,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authDetailsService: AuthDetailsService
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val filter = JwtFilter(jwtProperties, jwtTokenProvider, authDetailsService)
        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter::class.java)
    }
}
