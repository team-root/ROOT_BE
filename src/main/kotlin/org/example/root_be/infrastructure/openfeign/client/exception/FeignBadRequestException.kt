package org.example.root_be.infrastructure.openfeign.client.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

class FeignBadRequestException : CustomException(ErrorCode.FEIGN_BAD_REQUEST)
