package org.example.rootbe.domain.user.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND)
