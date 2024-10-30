package org.jason.application.http

import io.ktor.server.plugins.requestvalidation.*
import org.jason.application.dto.request.CreateUsersRequest

fun RequestValidationConfig.usersRoutesValidation() {
    validate<CreateUsersRequest> { request ->
        when {
            request.username.isBlank() || request.username.isEmpty() -> ValidationResult.Invalid("username is blank")
            request.pwd.isBlank() -> ValidationResult.Invalid("password is blank")
            else -> ValidationResult.Valid

        }
    }
}