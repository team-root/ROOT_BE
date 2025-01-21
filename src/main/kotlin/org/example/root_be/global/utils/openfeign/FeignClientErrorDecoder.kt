package org.example.root_be.global.utils.openfeign

import feign.Response
import feign.codec.ErrorDecoder
import org.example.root_be.global.utils.openfeign.exception.FeignBadRequestException
import org.example.root_be.global.utils.openfeign.exception.FeignServerException
import org.springframework.stereotype.Component

@Component
class FeignClientErrorDecoder : ErrorDecoder {
   override fun decode(methodKey: String, response: Response): Exception {
       return when (response.status()) {
           in 400..499 -> FeignBadRequestException()
           in 500..599 -> FeignServerException()
           else -> Exception("Unknown error occurred while calling the Feign client")
       }
   }
}
