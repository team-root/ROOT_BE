package org.example.root_be.global.utils.openfeign.exception

import org.example.root_be.global.err.exception.CustomException
import org.example.root_be.global.err.exception.ErrorCode

class FeignServerException : CustomException(ErrorCode.FEIGN_SERVER_ERROR)
