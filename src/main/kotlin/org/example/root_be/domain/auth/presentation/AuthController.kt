package org.example.root_be.domain.auth.presentation

import org.example.root_be.domain.auth.presentation.dto.request.LoginRequest
import org.example.root_be.domain.auth.presentation.dto.request.RefreshRequest
import org.example.root_be.domain.auth.presentation.dto.response.LoginResponse
import org.example.root_be.domain.auth.presentation.dto.response.RefreshResponse
import org.example.root_be.domain.auth.service.LoginService
import org.example.root_be.domain.auth.service.RefreshService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val refreshService: RefreshService,
    private val loginService: LoginService
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse =
        loginService.execute(loginRequest)

    @PostMapping("/refresh")
    fun refresh(@RequestBody refreshRequest: RefreshRequest): RefreshResponse =
        refreshService.execute(refreshRequest)
}