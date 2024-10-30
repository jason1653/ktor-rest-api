package org.jason.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.request.*
import org.jason.infrastructure.plugin.ApplicationMonitoringPlugin
import org.jason.infrastructure.plugin.NotFoundEvent

fun Application.configureMonitoring() {
    install(ApplicationMonitoringPlugin)
    monitor.subscribe(ApplicationStarted) {
        log.info("Server is started")
    }

    monitor.subscribe(ApplicationStopped) {
        log.info("Server is stopped")
        monitor.unsubscribe(ApplicationStarted) {}
        monitor.unsubscribe(ApplicationStopped) {}
    }

    monitor.subscribe(NotFoundEvent) { call ->
        log.info("Not found: ${call.request.path()}")
    }
}