package org.example.root_be.infrastructure.openfeign.client.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class UserInfoResponse(
   val id: String,
   @JsonProperty("account_id")
   val accountId: String,
   val password: String,
   val name: String,
   val grade: Int,
   @JsonProperty("class_num")
   val classNum: Int,
   val num: Int,
   @JsonProperty("user_role")
   val userRole: String,
   @JsonProperty("birth_day")
   val birthDay: String,
   val profileImgUrl: String,
   val clubName: String?
)