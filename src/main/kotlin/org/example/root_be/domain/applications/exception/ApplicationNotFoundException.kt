package org.example.root_be.domain.applications.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

object ApplicationNotFoundException: CustomException(ErrorCode.APPLICATION_NOT_FOUND)