package org.example.root_be.domain.volunteer.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object VolunteerPostNotFoundException: CustomException(ErrorCode.VOLUNTEER_POST_NOT_FOUND)