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
    private val jwtTokenProvider: JwtTokenProvider
) {

    @Bean
    fun filterChain(http: HttpSecurity, corsConfigurationSource: CorsConfigurationSource): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .cors { it.configurationSource(corsConfigurationSource) }
            .headers { it.frameOptions { frame -> frame.sameOrigin() } }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests {
                it
                    .requestMatchers("/auth/**").permitAll()

                    //student
                    .requestMatchers(
                        HttpMethod.GET,
                        "/user/mypage",
                        "/user/volunteer-verification"
                    ).hasRole("STUDENT")
                    .requestMatchers(HttpMethod.POST,
                        "/user/volunteer-application",
                        "/user/qrcode-scan"
                    ).hasRole("STUDENT")

                    //admin
                    .requestMatchers(HttpMethod.GET,
                        "/admin/qrcode-creation",
                        "/admin/mypage",
                        "/admin/inquiry/**",
                        "/admin/volunteer-application/**"
                    ).hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST,
                        "/admin/volunteer-hours/grants",
                        "/admin/role-assignment/**",
                        "/admin/volunteer-application/request",
                        "/admin/volunteer-posts/creation",
                        "/admin/schedules",
                        "/notifications"
                    ).hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PATCH,
                        "/admin/volunteer-posts/**",
                        "/admin/schedules/**"
                    ).hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE,
                        "/admin/volunteer-posts/**",
                        "/admin/schedules/**"
                    ).hasRole("ADMIN")

                    //student, admin
                    .requestMatchers(HttpMethod.GET,
                        "/schedules/inquiry",
                        "/schedules/**",
                        "/volunteer-posts",
                        "/volunteer-posts/**",
                        "/notifications"
                    ).hasAnyRole("STUDENT", "ADMIN")

                    .anyRequest().authenticated()
            }
            .with(FilterConfig(objectMapper, jwtTokenProvider)) {}

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}