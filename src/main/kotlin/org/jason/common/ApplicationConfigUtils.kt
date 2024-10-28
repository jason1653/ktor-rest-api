package org.jason.common

import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*

object ApplicationConfigUtils {
    fun getConfigProperty(path: String) =
        HoconApplicationConfig(ConfigFactory.load()).property(path).getString()
}