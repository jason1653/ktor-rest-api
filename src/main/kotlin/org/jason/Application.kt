package org.jason

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jason.config.configureDatabase
import org.jason.config.configureDependencyInjection
import org.jason.config.configureSerialization
import org.jason.infrastructure.config.configureRouting

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    //데이터베이스config
    configureDatabase()

    //Serialization config
    configureSerialization()

    //DI config
    configureDependencyInjection()

    //Routing config
    configureRouting()


}
