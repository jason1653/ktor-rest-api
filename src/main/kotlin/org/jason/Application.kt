package org.jason

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jason.plugins.configSecurity
import org.jason.plugins.configureSerialization
import org.jason.repository.UserRepository
import org.jason.routing.configureRouting
import org.jason.service.JwtService
import org.jason.service.UserService

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val userRepository = UserRepository()
    val userService = UserService(userRepository)
    val jwtService = JwtService(this, userService)

    configureSerialization()
    configSecurity(jwtService)
    configureRouting(userService, jwtService)
}
