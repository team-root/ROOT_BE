package org.example.root_be.domain.role.presentation

import org.example.root_be.domain.role.presentation.dto.request.GranRoleRequest
import org.example.root_be.domain.role.service.GrantRoleService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/volunteer/roles")
class RoleController(
    private val grantRoleService: GrantRoleService
) {
    @PostMapping("/{postId}")
    fun grantRoleService(
        @PathVariable postId: Long,
        @RequestBody request: GranRoleRequest
    ) {
        grantRoleService.execute(postId, request)
    }
}