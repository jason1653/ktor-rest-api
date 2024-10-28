package org.jason.routing

import User
import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.routing.*
import io.ktor.server.request.*
import io.ktor.server.response.*

import org.jason.routing.request.UserRequest
import org.jason.routing.response.UserResponse
import org.jason.service.UserService
import java.util.*


fun Route.userRoute(
    userService: UserService
) {
    post {
        val userRequest = call.receive<UserRequest>()
        val createUser = userService.save(
            user = userRequest.toModel()
        ) ?: return@post call.respond(HttpStatusCode.BadRequest)

        call.response.header(
            name = "id",
            value = createUser.id.toString()
        )

        call.respond(
            message = HttpStatusCode.Created,
        )
    }


    authenticate("another-auth") {
        get {
            val users = userService.findAll()

            call.respond(
                message = users.map(User::toResponse)
            )
        }
    }


    authenticate("another-auth") {

        get("/{id}") {
            val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)
            val user = userService.findById(id) ?: return@get call.respond(HttpStatusCode.NotFound)

            if(user.username != extractPrincipalUsername(call)) {
                return@get call.respond(HttpStatusCode.NotFound)
            }

            call.respond(
                message = user.toResponse()
            )
        }

    }




}

fun extractPrincipalUsername(call: RoutingCall): String? =
    call.principal<JWTPrincipal>()
        ?.payload
        ?.getClaim("username")
        ?.asString()

private fun UserRequest.toModel(): User {
    return User(
        id = UUID.randomUUID(),
        username = username,
        password = password
    )
}

private fun User.toResponse(): UserResponse {
    return UserResponse(
        id = this.id,
        username = this.username
    )
}