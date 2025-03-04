package org.example.rootbe.infrastructure.openfeign.client.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class UserInfoRequest(
    @JsonProperty("account_id")
    val accountId: String,
    val password: String,
)
