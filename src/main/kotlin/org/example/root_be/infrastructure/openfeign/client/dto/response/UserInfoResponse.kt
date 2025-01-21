package org.example.root_be.infrastructure.openfeign.client.dto.response

data class UserInfoResponse(
   val id: String,
   val accountId: String,
   val password: String,
   val name: String,
   val grade: Int,
   val classNum: Int,
   val num: Int,
   val userRole: String
)