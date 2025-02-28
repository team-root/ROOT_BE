package org.example.root_be.domain.user.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND)
