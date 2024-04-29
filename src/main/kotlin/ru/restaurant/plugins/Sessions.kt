package ru.restaurant.plugins

import io.ktor.server.application.*
import io.ktor.server.sessions.*
import io.ktor.util.*
import ru.restaurant.sessions.UserSession
import java.io.File

fun Application.configureSessions() {
    install(Sessions) {
        val secretSignKey = hex("4e0d8e5ebc109d15f53cfed03255d555")
        cookie<UserSession>(
            name = "user_session",
            storage = directorySessionStorage(File("build/.sessions"))
        ) {
            cookie.path = "/"
            cookie.maxAgeInSeconds = 60

            transform(SessionTransportTransformerMessageAuthentication(secretSignKey))
        }
    }
}