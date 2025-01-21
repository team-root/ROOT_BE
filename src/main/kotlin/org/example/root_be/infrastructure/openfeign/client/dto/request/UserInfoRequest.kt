package org.example.root_be.infrastructure.openfeign.client.dto.request

data class UserInfoRequest(
    val accountId: String,
    val password: String
)