package org.jason.plugins

import io.ktor.server.application.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}