package ru.restaurant

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*
import ru.restaurant.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSecurity()
    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
    }
    configureHTTP()
    configureSerialization()
    configureTemplating()
    configureRouting()
}
