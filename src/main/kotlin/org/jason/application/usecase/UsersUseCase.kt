package org.jason.application.usecase

import org.jason.application.dto.request.CreateUsersRequest
import org.jason.domain.repository.UsersRepository

class UsersUseCase(
    private val usersRepository: UsersRepository
) {
    suspend fun save(request: CreateUsersRequest) {
        val entity = request.toEntity()

        usersRepository.save(entity)
    }
}