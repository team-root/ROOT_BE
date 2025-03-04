package org.example.rootbe.domain.user.presentation

import jakarta.validation.Valid
import org.example.rootbe.domain.user.presentation.dto.request.AddStudentVolunteerRecordRequest
import org.example.rootbe.domain.user.presentation.dto.response.MyVolunteerActivityResponse
import org.example.rootbe.domain.user.presentation.dto.response.MypageResponse
import org.example.rootbe.domain.user.presentation.dto.response.StudentQueryResponse
import org.example.rootbe.domain.user.presentation.dto.response.StudentVolunteerActivityResponse
import org.example.rootbe.domain.user.service.AddStudentVolunteerRecordService
import org.example.rootbe.domain.user.service.MyVolunteerActivityService
import org.example.rootbe.domain.user.service.MypageService
import org.example.rootbe.domain.user.service.StudentQueryService
import org.example.rootbe.domain.user.service.StudentVolunteerActivityService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
@Validated
class UserController(
    private val mypageService: MypageService,
    private val myVolunteerActivityService: MyVolunteerActivityService,
    private val studentQueryService: StudentQueryService,
    private val studentVolunteerActivityService: StudentVolunteerActivityService,
    private val addStudentVolunteerRecordService: AddStudentVolunteerRecordService,
) {
    @GetMapping("/me")
    fun mypage(): MypageResponse = mypageService.execute()

    @GetMapping("/me/volunteer")
    fun myVolunteer(): MyVolunteerActivityResponse = myVolunteerActivityService.execute()

    @GetMapping
    fun studentQuery(): StudentQueryResponse = studentQueryService.execute()

    @GetMapping("/{userId}/volunteer")
    fun studentVolunteerActivity(
        @PathVariable userId: Long,
    ): StudentVolunteerActivityResponse = studentVolunteerActivityService.execute(userId)

    @PostMapping("/volunteer")
    fun addStudentVolunteerRecord(
        @Valid
        @RequestBody request: AddStudentVolunteerRecordRequest,
    ) = addStudentVolunteerRecordService.execute(request)
}
