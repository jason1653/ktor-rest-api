package org.jason.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import org.jason.application.http.usersRoutesValidation

fun Application.configureValidation() {
    install(RequestValidation) {
        usersRoutesValidation()
    }
}