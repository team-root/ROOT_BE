package org.example.root_be.global.utils.openfeign

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {
   @Bean
   fun feignLoggerLevel(): Logger.Level {
       return Logger.Level.FULL
   }
}
