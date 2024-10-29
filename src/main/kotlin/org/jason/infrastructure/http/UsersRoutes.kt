package org.jason.infrastructure.http

import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.jason.application.dto.request.CreateUsersRequest
import org.jason.application.service.UsersService

fun Route.usersRoutes(
    usersService: UsersService
) {
    post {
        val createUserRequest = call.receive<CreateUsersRequest>()


        usersService.save(
            request = createUserRequest
        )


    }
}