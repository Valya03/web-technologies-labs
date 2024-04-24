package ru.restaurant.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.swagger.codegen.v3.generators.html.StaticHtml2Codegen
import io.swagger.codegen.v3.generators.html.StaticHtmlCodegen
import kotlinx.css.code

fun Application.configureHTTP() {
    routing {
        swaggerUI(path = "docs", swaggerFile = "openapi/documentation.yaml") {
            this.customStyle("style/swagger.css")
        }
    }
}
