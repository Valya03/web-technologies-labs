package ru.restaurant

import com.typesafe.config.ConfigFactory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.routing.*
import ru.restaurant.db.DatabaseSingleton
import ru.restaurant.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val appConfig = HoconApplicationConfig(ConfigFactory.load())

    DatabaseSingleton.init()
    configureSecurity(appConfig)
    configureCORS()
    configureSessions()
    configureSerialization()
    configureSwagger()
    configureFreeMarker()
    configureRouting(appConfig)
}
