package org.example.rootbe.domain.applications.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

object ApplicationNotFoundException : CustomException(ErrorCode.APPLICATION_NOT_FOUND)
