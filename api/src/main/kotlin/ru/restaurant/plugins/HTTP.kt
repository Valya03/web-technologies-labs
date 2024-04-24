package ru.restaurant.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.code

fun Application.configureHTTP() {
    routing {
//        swaggerUI(path = "docs", swaggerFile = "openapi/documentation.yaml") {
//            this.customStyle("style/swagger.css")
//        }
    }
}
