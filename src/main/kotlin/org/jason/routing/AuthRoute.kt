package org.jason.routing

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jason.routing.request.LoginRequest
import org.jason.service.JwtService

fun Route.authRoute(
    jwtService: JwtService
) {

    post {
        val loginRequest = call.receive<LoginRequest>()

        val token = jwtService.createJwtToken(loginRequest)

        token?.let {
            call.respond(
                hashMapOf("token" to it)
            )
        } ?: call.respond(HttpStatusCode.Unauthorized)


    }

}