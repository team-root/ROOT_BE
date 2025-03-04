package org.example.rootbe.global.err.exception

abstract class CustomException(
    val errorCode: ErrorCode,
) : RuntimeException()
