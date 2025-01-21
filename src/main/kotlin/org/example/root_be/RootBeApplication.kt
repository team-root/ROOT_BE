package org.example.root_be

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class RootBeApplication

fun main(args: Array<String>) {
    runApplication<RootBeApplication>(*args)
}
