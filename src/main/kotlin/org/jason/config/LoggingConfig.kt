package org.jason.config

import io.ktor.server.application.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.Level
import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.slf4j.event.*
import io.ktor.server.routing.*

inline fun <reified T> T.logger(): Logger = LoggerFactory.getLogger(T::class.java)


fun Application.configureLogging() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
}