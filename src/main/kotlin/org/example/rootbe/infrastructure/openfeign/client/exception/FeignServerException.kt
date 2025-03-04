package org.example.rootbe.infrastructure.openfeign.client.exception

import org.example.rootbe.global.err.exception.CustomException
import org.example.rootbe.global.err.exception.ErrorCode

class FeignServerException : CustomException(ErrorCode.FEIGN_SERVER_ERROR)
