package org.jason.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.jason.application.service.UsersService
import org.jason.infrastructure.http.usersRoutes
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val usersService: UsersService by inject()

    routing {
        route("/api/users") {
            usersRoutes(usersService)
        }
    }
}