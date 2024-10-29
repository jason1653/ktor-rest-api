package org.jason.config

import io.ktor.server.application.*
import io.ktor.server.config.*
import org.jason.common.ApplicationConfigUtils
import org.jason.config.DatabaseConfigUtils.connectDataBase
import org.jetbrains.exposed.sql.Database

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
}