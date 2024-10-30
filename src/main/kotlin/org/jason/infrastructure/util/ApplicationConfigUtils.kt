package org.jason.infrastructure.util

import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*

object ApplicationConfigUtils {

    private val config = HoconApplicationConfig(ConfigFactory.load())

    fun getConfigProperty(path: String) =
        config.property(path).getString()
}