package org.example.rootbe.domain.auth.presentation

import jakarta.validation.Valid
import org.example.rootbe.domain.auth.presentation.dto.request.LoginRequest
import org.example.rootbe.domain.auth.presentation.dto.request.RefreshRequest
import org.example.rootbe.domain.auth.presentation.dto.response.LoginResponse
import org.example.rootbe.domain.auth.presentation.dto.response.RefreshResponse
import org.example.rootbe.domain.auth.service.LoginService
import org.example.rootbe.domain.auth.service.RefreshService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
@Validated
class AuthController(
    private val refreshService: RefreshService,
    private val loginService: LoginService,
) {
    @PostMapping("/login")
    fun login(
        @Valid
        @RequestBody loginRequest: LoginRequest,
    ): LoginResponse = loginService.execute(loginRequest)

    @PostMapping("/refresh")
    fun refresh(
        @Valid
        @RequestBody refreshRequest: RefreshRequest,
    ): RefreshResponse = refreshService.execute(refreshRequest)
}
