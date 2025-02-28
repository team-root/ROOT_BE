package org.example.root_be.domain.detail.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object VolunteerDetailNotFoundException : CustomException(ErrorCode.VOLUNTEER_DETAIL_NOT_FOUND)
