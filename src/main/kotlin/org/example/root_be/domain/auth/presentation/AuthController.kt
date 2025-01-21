package org.example.root_be.domain.auth.presentation

import org.example.root_be.domain.auth.presentation.dto.request.RefreshRequest
import org.example.root_be.domain.auth.presentation.dto.response.RefreshResponse
import org.example.root_be.domain.auth.service.RefreshService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val refreshService: RefreshService
) {
    @PostMapping("/refresh")
    fun refresh(@RequestBody refreshRequest: RefreshRequest): RefreshResponse =
        refreshService.execute(refreshRequest)
}