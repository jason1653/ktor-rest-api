package org.jason.infrastructure.config

import io.ktor.server.application.*
import org.jason.infrastructure.config.DatabaseConfigUtils.connectDataBase
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    connectDataBase()
}

object DatabaseConfigUtils {
    fun connectDataBase() {

        val url = ApplicationConfigUtils.getConfigProperty("database.source.url")
        val driver = ApplicationConfigUtils.getConfigProperty("database.source.driver")
        val user = ApplicationConfigUtils.getConfigProperty("database.source.user")
        val password = ApplicationConfigUtils.getConfigProperty("database.source.password")

        Database.connect(
            url = url,
            driver = driver,
            user = user,
            password = password
        )
    }

    fun <T> dbQuery(
        block: () -> T
    ): T = transaction {
        block()
    }
}