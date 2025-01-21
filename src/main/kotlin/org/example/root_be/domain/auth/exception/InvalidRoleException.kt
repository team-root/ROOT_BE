package org.example.root_be.domain.auth.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

class InvalidRoleException : CustomException(ErrorCode.INVALID_ROLE)