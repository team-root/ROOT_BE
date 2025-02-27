package org.example.root_be.domain.applications.presentation.dto.request

import jakarta.validation.constraints.NotNull

data class ProcessVolunteerApplicationRequest (
    @field:NotNull(message = "신청 ID는 필수입니다.")
    val applicationId: Long,

    @field:NotNull(message = "수락/거절 여부는 필수입니다.")
    val isAccepted: Boolean
)