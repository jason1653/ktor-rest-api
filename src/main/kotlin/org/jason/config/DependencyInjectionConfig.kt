package org.jason.config

import io.ktor.server.application.*
import org.jason.application.service.UsersService
import org.jason.domain.repository.UsersRepository
import org.jason.infrastructure.repository.UsersRepositoryImpl
import org.koin.ktor.plugin.Koin
import org.koin.dsl.module

val dependencyInjectionModule = module {
    single {
        UsersService(
            usersRepository = get()
        )
    }

    single<UsersRepository> { UsersRepositoryImpl() }
}


fun Application.configureDependencyInjection() {
    install(Koin) {
        modules(dependencyInjectionModule)
    }
}
