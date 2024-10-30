package org.jason.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import org.jason.application.dto.ErrorResponse

fun Application.configureException() {
    install(StatusPages) {
        exception<RequestValidationException> { call, cause ->
            if (cause.reasons.isNotEmpty()) {
                call.respond(
                    HttpStatusCode.BadRequest,
                    ErrorResponse(
                        HttpStatusCode.BadRequest.value,
                        "validation_error",
                        cause.reasons.joinToString(", ")
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.BadRequest,
                    ErrorResponse(
                        HttpStatusCode.BadRequest.value,
                        "validation_error",
                        cause.message ?: "Bad Request"
                    )
                )
            }
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