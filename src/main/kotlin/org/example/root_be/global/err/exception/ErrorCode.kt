package org.example.root_be.global.err.exception

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    INVALID_ROLE("Invalid role.", 400),
    INVALID_TOKEN("Invalid Token", 401),
    EXPIRED_TOKEN("Expired Token", 401),
    VOLUNTEER_POST_NOT_FOUND("Post Not Found", 404),
    VOLUNTEER_ROLE_NOT_FOUND("Role Not Found", 404),
    VOLUNTEER_DETAIL_NOT_FOUND("Detail Not Found", 404),
    USER_NOT_FOUND("User Not Found", 404),
    INVALID_PASSWORD("Invalid Password", 401),
    FEIGN_BAD_REQUEST("External API request is invalid.", 400),
    FEIGN_SERVER_ERROR("An external server error occurred.", 500),
    APPLICATION_NOT_FOUND("Application Not Found", 404),
}
