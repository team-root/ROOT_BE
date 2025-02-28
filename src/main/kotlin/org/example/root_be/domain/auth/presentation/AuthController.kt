package org.example.root_be.domain.auth.presentation

import jakarta.validation.Valid
import org.example.root_be.domain.auth.presentation.dto.request.LoginRequest
import org.example.root_be.domain.auth.presentation.dto.request.RefreshRequest
import org.example.root_be.domain.auth.presentation.dto.response.LoginResponse
import org.example.root_be.domain.auth.presentation.dto.response.RefreshResponse
import org.example.root_be.domain.auth.service.LoginService
import org.example.root_be.domain.auth.service.RefreshService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
@Validated
class AuthController(
    private val refreshService: RefreshService,
    private val loginService: LoginService
) {
    @PostMapping("/login")
    fun login(
        @Valid
        @RequestBody loginRequest: LoginRequest
    ): LoginResponse =
        loginService.execute(loginRequest)

    @PostMapping("/refresh")
    fun refresh(
        @Valid
        @RequestBody refreshRequest: RefreshRequest)
    : RefreshResponse =
        refreshService.execute(refreshRequest)
}