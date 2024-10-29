package org.jason.domain.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.Instant

object Users : Table("USERS") {
    // 컬럼 정의
    val uid = varchar("UID", 20)
    val username = varchar("USERNAME", 30).nullable()
    val pwd = varchar("PWD", 100).nullable()
    val registDateTime = timestamp("REGIST_DATETIME").nullable()

    // Primary Key 설정
    override val primaryKey = PrimaryKey(uid, name = "USERS_pkey")
}

data class UsersModel(
    val uid: String,
    val username: String,
    val pwd: String,
    val registDateTime: Instant?
)