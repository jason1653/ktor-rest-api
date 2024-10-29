package org.jason.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.jason.application.usecase.UsersUseCase
import org.jason.application.http.usersRoutes
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val usersUseCase: UsersUseCase by inject()

    routing {
        route("/api/users") {
            usersRoutes(usersUseCase)
        }
    }
}