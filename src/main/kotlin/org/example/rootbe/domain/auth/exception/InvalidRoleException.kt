package org.example.rootbe.domain.auth.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

class InvalidRoleException : CustomException(ErrorCode.INVALID_ROLE)
