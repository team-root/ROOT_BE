package org.example.root_be.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.root_be.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
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
    private val objectMapper: ObjectMapper,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    @Bean
    fun filterChain(
        http: HttpSecurity,
        corsConfigurationSource: CorsConfigurationSource,
    ): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .cors { it.configurationSource(corsConfigurationSource) }
            .headers { it.frameOptions { frame -> frame.sameOrigin() } }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it
                    .requestMatchers("/auth/**").permitAll()
                    // ADMIN, STUDENT 공통 엔드포인트
                    .requestMatchers(
                        HttpMethod.GET,
                        "/users/me",
                        "/posts",
                        "/posts/{postId}",
                        "/schedules",
                        "/schedules/{date}",
                        "/notifications",
                    ).hasAnyRole("ADMIN", "STUDENT")
                    // STUDENT 전용 엔드포인트
                    .requestMatchers(
                        HttpMethod.GET,
                        "/users/me/volunteer",
                    ).hasRole("STUDENT")
                    .requestMatchers(
                        HttpMethod.POST,
                        "/volunteer/applications/{postId}",
                        "/qr/scan",
                    ).hasRole("STUDENT")
                    // ADMIN 전용 엔드포인트
                    .requestMatchers(
                        HttpMethod.GET,
                        "/users",
                        "/users/{userId}/volunteer",
                        "/volunteer/applications/{postId}",
                    ).hasRole("ADMIN")
                    .requestMatchers(
                        HttpMethod.POST,
                        "/users/volunteer",
                        "/posts",
                        "/volunteer/applications/status",
                        "/volunteer/roles/{postId}",
                        "/schedules",
                        "/qr",
                        "/notifications",
                    ).hasRole("ADMIN")
                    .requestMatchers(
                        HttpMethod.PATCH,
                        "/posts/{postId}",
                        "/schedules/{date}",
                    ).hasRole("ADMIN")
                    .requestMatchers(
                        HttpMethod.DELETE,
                        "/posts/{postId}",
                        "/schedules/{date}",
                    ).hasRole("ADMIN")
                    .anyRequest().authenticated()
            }
            .with(FilterConfig(objectMapper, jwtTokenProvider)) {}

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
