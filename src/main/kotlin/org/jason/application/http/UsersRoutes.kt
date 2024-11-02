package org.jason.application.http

import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jason.application.dto.response.SuccessResponse
import org.jason.application.dto.request.CreateUsersRequest
import org.jason.application.mapper.UsersMapper
import org.jason.application.usecase.UsersUseCase
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

fun Route.usersRoutes(
    usersUseCase: UsersUseCase,
) {
    post {
        val createUserRequest = call.receive<CreateUsersRequest>()
        val mapper = Mappers.getMapper(UsersMapper::class.java)
        val dto = mapper.toDTO(createUserRequest)

        usersUseCase.save(dto)
    }

    get("/{id}") {
        val id = call.parameters["id"]

        val userEntity = usersUseCase.findUserById(id!!) ?: throw NotFoundException("회원데이터가 존재하지 않습니다")

        val response = SuccessResponse(
            body = userEntity
        )

        call.respond(response)
    }

}