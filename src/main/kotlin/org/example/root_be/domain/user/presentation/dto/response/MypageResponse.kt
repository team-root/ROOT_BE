package org.example.root_be.domain.user.presentation.dto.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MypageResponse(
    val name: String,
    val number: Int?,
    val area: List<String>,
    val volunteerTime: Int?,
)
