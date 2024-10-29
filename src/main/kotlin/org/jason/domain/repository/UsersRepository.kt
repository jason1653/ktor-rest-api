package org.jason.domain.repository

import org.jason.domain.model.UsersEntity

interface UsersRepository {
    suspend fun findUserById(id: String): UsersEntity?
    suspend fun save(user: UsersEntity)
}


