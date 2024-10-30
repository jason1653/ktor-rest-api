package org.jason.infrastructure.plugin

import io.ktor.events.EventDefinition
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.application.hooks.*
import io.ktor.server.request.*

val ApplicationMonitoringPlugin = createApplicationPlugin(name = "ApplicationMonitoringPlugin") {
    on(MonitoringEvent(ApplicationStarted)) { application ->
        application.log.info("Server is started")
    }
    on(MonitoringEvent(ApplicationStopped)) { application ->
        application.log.info("Server is stopped")
        // Release resources and unsubscribe from events
        application.monitor.unsubscribe(ApplicationStarted) {}
        application.monitor.unsubscribe(ApplicationStopped) {}
    }
    on(ResponseSent) { call ->
        if (call.response.status() == HttpStatusCode.NotFound) {
            application.log.info("Not found: ${call.request.uri}")
            this@createApplicationPlugin.application.monitor.raise(NotFoundEvent, call)
        }

        if (call.response.status() == HttpStatusCode.BadRequest) {
            application.log.info("Bad request: ${call.request.uri}")

        }



    }
}

val NotFoundEvent: io.ktor.events.EventDefinition<ApplicationCall> = EventDefinition()