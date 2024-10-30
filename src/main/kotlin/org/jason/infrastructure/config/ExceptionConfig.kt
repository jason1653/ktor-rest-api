package org.jason.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import org.jason.application.dto.ErrorResponse

fun Application.configureException() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }

        exception<NotFoundException> { call, cause ->
            print("404 오류")
            call.respond(HttpStatusCode.NotFound)
        }

        status(HttpStatusCode.NotFound) { call, status ->
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponse(
                    HttpStatusCode.NotFound.value,
                    HttpStatusCode.NotFound.value.toString(),
                    "Not Found"
                )
            )
        }
    }
}