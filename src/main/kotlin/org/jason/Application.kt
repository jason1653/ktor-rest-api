package org.jason

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jason.config.configureDatabase
import org.jason.config.configureDependencyInjection
import org.jason.infrastructure.config.configureRouting
import org.jason.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    configureDatabase()
    configureSerialization()
    configureDependencyInjection()
    configureRouting()
//    configSecurity(jwtService)
//    configureRouting(userService, jwtService)


}
