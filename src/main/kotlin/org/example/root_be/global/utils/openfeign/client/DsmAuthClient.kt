package org.example.root_be.global.utils.openfeign.client

import org.example.root_be.domain.auth.presentation.dto.request.LoginRequestDto
import org.springframework.cloud.openfeign.FeignClient;
import org.example.root_be.global.utils.openfeign.client.dto.response.UserInfoResponse
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "school-auth", url = "\${school.auth.url}")
interface DsmAuthClient {
   @PostMapping("/user-auth")
   fun getUserInfo(request: LoginRequestDto): UserInfoResponse
}
