package ru.restaurant.plugins

import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.ktor.server.application.*

fun Application.configureSwagger() {
    install(SwaggerUI) {
        swagger {
            swaggerUrl = "docs"
            forwardRoot = true
        }
        info {
            title = "Some restaurant API"
            version = "latest"
            description = "API for handling application forms for our restaurant"
        }
        server {
            url = "http://localhost:8080"
            description = "Development Server"
        }

        tag("form") {
            description = "Methods for working with forms"
        }
    }
}