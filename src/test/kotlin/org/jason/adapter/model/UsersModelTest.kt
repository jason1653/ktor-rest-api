package org.jason.adapter.model

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class UsersModelTest {

    @Test
    fun `UsersModel 생성 테스트 코드 실행`(): Unit {
        val usersModel = UsersModel(
            uid = "123456789",
            username = "test",
            pwd = "test"
        )

        assertEquals("123456789", usersModel.uid, "UID가 일치하지 않습니다")
        assertEquals("test", usersModel.username, "Username이 일치하지 않습니다")
        assertEquals("test", usersModel.pwd, "Password가 일치하지 않습니다")
    }
}