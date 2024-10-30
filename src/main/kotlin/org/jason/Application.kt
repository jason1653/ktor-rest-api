package org.jason

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jason.infrastructure.config.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", watchPaths = listOf("classes"), module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    //데이터베이스config
    configureDatabase()

    //Serialization config
    configureSerialization()

    configureValidation()


    configureException()

    //모니터링
    configureMonitoring()


    //DI config
    configureDependencyInjection()

    //Routing config
    configureRouting()

    configureMicrometerMetrics()



}
