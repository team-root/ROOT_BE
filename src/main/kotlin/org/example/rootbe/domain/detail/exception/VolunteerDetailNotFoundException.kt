package org.example.rootbe.domain.detail.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

object VolunteerDetailNotFoundException : CustomException(ErrorCode.VOLUNTEER_DETAIL_NOT_FOUND)
