package org.example.root_be.global.utils.openfeign.client.dto.request

data class UserInfoRequest(
    val accountId: String,
    val password: String
)