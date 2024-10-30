package org.jason

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jason.infrastructure.config.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    //데이터베이스config
    configureDatabase()

    //모니터링
    configureMonitoring()

    //Serialization config
    configureSerialization()

    //DI config
    configureDependencyInjection()

    //Routing config
    configureRouting()


}
