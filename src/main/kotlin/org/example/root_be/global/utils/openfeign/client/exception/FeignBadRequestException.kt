package org.example.root_be.global.utils.openfeign.exception

import org.example.root_be.global.error.exception.CustomException
import org.example.root_be.global.error.exception.ErrorCode

class FeignBadRequestException : CustomException(ErrorCode.FEIGN_BAD_REQUEST)
