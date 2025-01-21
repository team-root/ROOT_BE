package org.example.root_be.global.err.exception

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    INVALID_ROLE("Invalid role.", 400),
    INVALID_TOKEN("Invalid Token", 401),
    EXPIRED_TOKEN("Expired Token", 401),
    USER_NOT_FOUND("User Not Found", 404),
    INVALID_PASSWORD("Invalid Password", 401),
    FEIGN_BAD_REQUEST("External API request is invalid.", 400),
    FEIGN_SERVER_ERROR("An external server error occurred.", 500)
}
