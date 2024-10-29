package org.jason.application.service

import org.jason.application.dto.request.CreateUsersRequest
import org.jason.domain.repository.UsersRepository

class UsersService(
    private val usersRepository: UsersRepository
) {
    suspend fun save(request: CreateUsersRequest) {
        val entity = request.toEntity()

        usersRepository.save(entity)
    }
}