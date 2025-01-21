package org.example.root_be.domain.auth.presentation

import org.example.root_be.domain.auth.presentation.dto.response.RefreshResponse
import org.example.root_be.domain.auth.service.RefreshService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val refreshService: RefreshService
) {
    @PostMapping("/refresh")
    fun refresh(@RequestHeader("X-Refresh-Token") refreshToken: String): RefreshResponse =
        refreshService.execute(refreshToken)
}