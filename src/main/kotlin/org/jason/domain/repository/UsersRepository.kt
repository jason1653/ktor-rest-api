package org.jason.domain.repository

import org.jason.adapter.dto.UsersDTO
import org.jason.domain.model.UsersEntity

interface UsersRepository {
    suspend fun findUserById(id: String): UsersEntity?
    suspend fun save(user: UsersDTO): String
}


