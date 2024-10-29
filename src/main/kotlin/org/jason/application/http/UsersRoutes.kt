package org.jason.application.http

import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.jason.application.dto.request.CreateUsersRequest
import org.jason.application.usecase.UsersUseCase

fun Route.usersRoutes(
    usersUseCase: UsersUseCase
) {
    post {
        val createUserRequest = call.receive<CreateUsersRequest>()


        usersUseCase.save(
            request = createUserRequest
        )


    }
}