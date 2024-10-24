package org.jason.routing.response

import kotlinx.serialization.Serializable
import org.jason.util.UUIDSerializer
import java.util.*


@Serializable
data class UserResponse(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val username: String,
)
