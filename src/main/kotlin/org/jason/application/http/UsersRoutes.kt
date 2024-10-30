package org.jason.application.http

import io.ktor.http.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jason.application.dto.ErrorResponse
import org.jason.application.dto.SuccessResponse
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

    get("/{id}") {
        val id = call.parameters["id"]

        val userEntity = usersUseCase.findUserById(id!!)

        if(userEntity == null) {
            throw NotFoundException("회원데이터가 존재하지 않습니다")
        }

        val response = SuccessResponse(
            body = userEntity
        )

        call.respond(response)
    }
}