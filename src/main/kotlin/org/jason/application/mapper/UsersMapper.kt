package org.jason.application.mapper

import org.jason.adapter.model.UsersModel
import org.jason.application.dto.request.CreateUsersRequest
import org.jason.application.dto.service.UsersDTO
import org.mapstruct.Mapper

@Mapper
interface UsersMapper {
    fun toDTO(createUserRequest: CreateUsersRequest): UsersDTO
    fun toModel(dto: UsersDTO): UsersModel
}