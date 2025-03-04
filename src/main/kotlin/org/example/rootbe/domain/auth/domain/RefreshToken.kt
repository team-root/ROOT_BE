package org.example.rootbe.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash("refresh_token")
class RefreshToken(
    @Id
    val id: String,
    @Indexed
    val token: String,
    @TimeToLive
    val ttl: Long,
    val userId: Long,
)
