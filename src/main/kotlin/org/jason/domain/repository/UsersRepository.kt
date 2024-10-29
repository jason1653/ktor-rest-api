package org.jason.domain.repository

import org.jason.config.DatabaseConfigUtils.dbQuery
import org.jason.domain.model.Users
import org.jason.domain.model.UsersModel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

interface UsersRepository {
    suspend fun findUserById(id: String): UsersModel?
}


class UsersRepositoryImpl : UsersRepository {

    override suspend fun findUserById(id: String) = dbQuery {
        return@dbQuery Users.selectAll().where { Users.uid eq id }
            .mapNotNull { toUser(it) }
            .singleOrNull()

    }

    private fun toUser(row: ResultRow): UsersModel {
        return UsersModel(
            uid = row[Users.uid], // ResultRow에서 "UID" 컬럼 값을 가져옵니다.
            username = row[Users.username] ?: "", // "USERNAME" 컬럼 값을 가져옵니다.
            pwd = row[Users.pwd] ?: "", // "PWD" 컬럼 값을 가져옵니다.
            registDateTime = row[Users.registDateTime] // "REGIST_DATETIME" 컬럼 값을 가져옵니다.
        )
    }


}
