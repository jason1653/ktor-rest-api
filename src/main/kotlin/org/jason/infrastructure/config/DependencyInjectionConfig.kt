package org.jason.infrastructure.config

import io.ktor.server.application.*
import org.jason.application.usecase.UsersUseCase
import org.jason.domain.repository.UsersRepository
import org.jason.adapter.repository.UsersRepositoryImpl
import org.koin.ktor.plugin.Koin
import org.koin.dsl.module


val dependencyInjectionModule = module {
    single {
        UsersUseCase(
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
