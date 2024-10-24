package org.jason.routing

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.jason.service.JwtService
import org.jason.service.UserService

fun Application.configureRouting(
    userService: UserService,
    jwtService: JwtService
) {
    routing {

        route("/api/auth") {
            authRoute(jwtService)
        }

        route("/api/user") {
            userRoute(userService)
        }
    }
}