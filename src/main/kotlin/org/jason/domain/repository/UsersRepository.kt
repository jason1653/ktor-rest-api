package org.jason.domain.repository

import org.jason.config.DatabaseConfigUtils.dbQuery
import org.jason.domain.model.UsersTable
import org.jason.domain.model.UsersEntity
import org.jetbrains.exposed.sql.*

interface UsersRepository {
    suspend fun findUserById(id: String): UsersEntity?
    suspend fun save(user: UsersEntity)
}


