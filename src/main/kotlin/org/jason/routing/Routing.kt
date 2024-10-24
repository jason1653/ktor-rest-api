package org.jason.routing

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.jason.service.UserService

fun Application.configureRouting(
    userService: UserService
) {
    routing {
        route("/api/user") {
            userRoute(userService)
        }
    }
}