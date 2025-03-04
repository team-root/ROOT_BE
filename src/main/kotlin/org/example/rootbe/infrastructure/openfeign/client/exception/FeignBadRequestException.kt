package org.example.rootbe.infrastructure.openfeign.client.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

class FeignBadRequestException : CustomException(ErrorCode.FEIGN_BAD_REQUEST)
