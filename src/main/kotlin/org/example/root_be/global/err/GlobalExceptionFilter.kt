package org.example.root_be.global.err

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.example.root_be.global.err.exception.CustomException
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            val errorResponse = when (e) {
                is CustomException -> ErrorResponse(e.errorCode.message, e.errorCode.status)
                else -> ErrorResponse(e.message ?: "Internal Server Error", HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
            }

            response.status = errorResponse.status
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            objectMapper.writeValue(response.outputStream, errorResponse)
        }
    }
}