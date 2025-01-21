package org.example.root_be.global.utils.openfeign.client

import org.example.root_be.global.utils.openfeign.client.dto.request.UserInfoRequest
import org.springframework.cloud.openfeign.FeignClient;
import org.example.root_be.global.utils.openfeign.client.dto.response.UserInfoResponse
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "dsm-auth", url = "\${dsm.auth.url}")
interface DsmAuthClient {
   @PostMapping("/user-data")
   fun getUserInfo(userInfoRequest: UserInfoRequest): UserInfoResponse
}
