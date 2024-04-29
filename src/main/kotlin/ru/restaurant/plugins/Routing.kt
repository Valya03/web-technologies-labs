package ru.restaurant.plugins

import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.restaurant.routing.configureAuthRoutes
import ru.restaurant.routing.configureFormRoutes

fun Application.configureRouting(appConfig: HoconApplicationConfig) {

    routing {

        get("/api/healthcheck", {
            description = "Check if method is up"
        }) {
            call.respondText("Hello World!")
        }

        configureFormRoutes()
        configureAuthRoutes(appConfig)

    }
}
