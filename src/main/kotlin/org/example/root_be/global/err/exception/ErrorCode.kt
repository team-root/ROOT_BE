package org.example.root_be.global.err.exception

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    INVALID_TOKEN("Invalid Token", 401),
    EXPIRED_TOKEN("Expired Token", 401),
    USER_NOT_FOUND("User Not Found", 404),
    INVALID_PASSWORD("Invalid Password", 401)
}
