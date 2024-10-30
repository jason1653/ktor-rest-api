package org.jason.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.http.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import org.jason.application.dto.ErrorResponse
import org.jetbrains.exposed.exceptions.ExposedSQLException
import java.sql.SQLException

fun Application.configureException() {
    install(StatusPages) {

        //Validation Exception
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

        exception<IllegalArgumentException> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest,
                ErrorResponse(
                    code = HttpStatusCode.BadRequest.value,
                    status = "illegal_argument_error",
                    message = cause.message ?: "The input provided is invalid"
                )
            )
        }

        exception<NotFoundException> { call, cause ->
            call.respond(
                HttpStatusCode.NotFound,
                ErrorResponse(
                    HttpStatusCode.NotFound.value,
                    "not_found_error",
                    cause.message ?: "Not Found"
                )
            )
        }

        exception<ExposedSQLException> { call, cause ->
            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResponse(
                    HttpStatusCode.InternalServerError.value,
                    "internal_server_error",
                    cause.message ?: "Internal Server Error"
                )
            )
        }

        exception<SQLException> { call, cause ->
            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResponse(
                    HttpStatusCode.InternalServerError.value,
                    "internal_server_error",
                    cause.message ?: "Internal Server Error"
                )
            )
        }


//        status(HttpStatusCode.NotFound) { call, cause ->
//
//            print("OK")
//            call.respond(
//                HttpStatusCode.NotFound,
//                ErrorResponse(
//                    HttpStatusCode.NotFound.value,
//                    HttpStatusCode.NotFound.value.toString(),
//                    cause ?: "Not Found"
//                )
//            )
//        }

    }
}