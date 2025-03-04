package org.example.rootbe.domain.post.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

object VolunteerPostNotFoundException : CustomException(ErrorCode.VOLUNTEER_POST_NOT_FOUND)
