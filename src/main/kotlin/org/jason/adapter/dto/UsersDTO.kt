package org.jason.adapter.dto

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

data class UsersDTO(
    val uid: String? = null,
    val username: String,
    val pwd: String,
    val registDatetime: LocalDateTime = LocalDateTime.now()
)
