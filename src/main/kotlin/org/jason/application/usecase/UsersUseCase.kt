package org.jason.application.usecase

import org.jason.adapter.dto.UsersDTO
import org.jason.application.dto.request.CreateUsersRequest
import org.jason.domain.repository.UsersRepository

class UsersUseCase(
    private val usersRepository: UsersRepository
) {
    suspend fun save(usersDto: UsersDTO): String {
        return usersRepository.save(usersDto)
    }

    suspend fun findUserById(id: String) = usersRepository.findUserById(id)
}