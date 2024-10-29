package org.jason.infrastructure.repository

import org.jason.config.DatabaseConfigUtils.dbQuery
import org.jason.domain.model.UsersEntity
import org.jason.domain.model.UsersTable
import org.jason.domain.repository.UsersRepository
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class UsersRepositoryImpl : UsersRepository {
    override suspend fun findUserById(id: String) = dbQuery {
        return@dbQuery UsersTable.selectAll().where { UsersTable.uid eq id }
            .mapNotNull { toUser(it) }
            .singleOrNull()
    }

    override suspend fun save(user: UsersEntity) {
        dbQuery {
            UsersTable.insert {
                it[uid] = user.uid
                it[username] = user.username
                it[pwd] = user.pwd
                it[registDateTime] = user.registDateTime
            }
        }
    }

    private fun toUser(row: ResultRow): UsersEntity {
        return UsersEntity(
            uid = row[UsersTable.uid], // ResultRow에서 "UID" 컬럼 값을 가져옵니다.
            username = row[UsersTable.username] ?: "", // "USERNAME" 컬럼 값을 가져옵니다.
            pwd = row[UsersTable.pwd] ?: "", // "PWD" 컬럼 값을 가져옵니다.
            registDateTime = row[UsersTable.registDateTime] // "REGIST_DATETIME" 컬럼 값을 가져옵니다.
        )
    }
}
