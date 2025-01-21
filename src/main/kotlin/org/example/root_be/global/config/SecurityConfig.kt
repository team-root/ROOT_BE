package org.example.root_be.global.config

import org.example.root_be.global.security.auth.AuthDetailsService
import org.example.root_be.global.security.jwt.JwtProperties
import org.example.root_be.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtProperties: JwtProperties,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authDetailsService: AuthDetailsService
) {

    @Bean
    fun filterChain(http: HttpSecurity, corsConfigurationSource: CorsConfigurationSource): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .cors { it.configurationSource(corsConfigurationSource) }
            .headers { it.frameOptions { frame -> frame.sameOrigin() } }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it.requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
            }
            .with(FilterConfig(jwtProperties, jwtTokenProvider, authDetailsService)) {}

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}