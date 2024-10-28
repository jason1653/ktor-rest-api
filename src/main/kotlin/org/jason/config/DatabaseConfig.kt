package org.jason.config

import io.ktor.server.application.*
import io.ktor.server.config.*
import org.jason.config.DatabaseConfigUtils.connectDataBase
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    connectDataBase()
}

object DatabaseConfigUtils {
    fun connectDataBase() {
//        Database.connect()
    }
}