package org.example.root_be.global.err.exception

abstract class CustomException(
    val errorCode: ErrorCode,
) : RuntimeException()
