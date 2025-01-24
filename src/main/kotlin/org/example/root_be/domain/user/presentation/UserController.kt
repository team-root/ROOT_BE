package org.example.root_be.domain.user.presentation

import org.example.root_be.domain.user.presentation.dto.response.MypageResponse
import org.example.root_be.domain.user.presentation.dto.response.StudentQueryResponse
import org.example.root_be.domain.user.service.MypageService
import org.example.root_be.domain.user.service.StudentQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (
    private val mypageService: MypageService,
    private val studentQueryService: StudentQueryService
){
    @GetMapping("/me")
    fun mypage(): MypageResponse = mypageService.execute()

    @GetMapping
    fun studentQuery(): StudentQueryResponse = studentQueryService.execute()
}