package org.jason.application.dto.request

import kotlinx.serialization.Serializable
import org.jason.domain.model.UsersEntity
import java.time.Instant

@Serializable
data class CreateUsersRequest(
    val username: String,
    val pwd: String
) {
    fun toEntity(): UsersEntity {
        return UsersEntity(
            uid = "1111111",
            username = this.username,
            pwd = this.pwd,
            registDateTime = Instant.now()
        )
    }
}