package org.example.root_be.domain.user.presentation

import org.example.root_be.domain.user.presentation.dto.response.MypageResponse
import org.example.root_be.domain.user.service.MypageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
    private val mypageService: MypageService
){
    @GetMapping("/me")
    fun mypage(): MypageResponse = mypageService.execute()
}