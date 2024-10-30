package org.jason.adapter.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.jason.domain.model.UsersEntity
import org.jason.domain.repository.UsersRepository
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.time.Instant

class UsersRepositoryImplTest {
    private lateinit var usersRepository: UsersRepositoryImpl


    @Before
    fun setup() {
        usersRepository = mockk()

    }


    @Test
    fun `UserRepository Save 테스트 코드 실행`(): Unit = runBlocking {
        val userEntity = UsersEntity(
            uid = "123456789",
            username = "test",
            pwd = "test",
            registDateTime = Instant.now()
        )

        coEvery { usersRepository.save(any()) } returns "123456789"

        val result = usersRepository.save(userEntity)
        assertEquals("123456789", result, "UID가 일치하지 않습니다")


        coVerify(exactly = 1) { usersRepository.save(userEntity) }
    }
}

