package ru.restaurant.plugins

import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.css.Position
import ru.restaurant.getImageFromResources
import ru.restaurant.sessions.UserSession
import java.io.File

val navigationMenu = listOf(
    NavigationItem("ГЛАВНАЯ", "/"),
    NavigationItem("МЕНЮ", "/menu"),
    NavigationItem("О НАС", "/about_us"),
    NavigationItem("БРОНЬ", "/booking"),
)

fun Application.configureFreeMarker() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    routing {
        staticFiles("/static", File("static"))
        staticResources("/static", "static")

        get("/") {
            call.respondTemplate(
                "index.ftl", mapOf(
                    "navmenu" to navigationMenu
                )
            )
        }

        get("/menu") {
            call.respondTemplate(
                "menu.ftl", mapOf(
                    "navmenu" to navigationMenu
                )
            )
        }

        get("/about_us") {
            call.respondTemplate(
                "about_us.ftl", mapOf(
                    "navmenu" to navigationMenu
                )
            )
        }

        get("booking") {
            val userSession = call.sessions.get<UserSession>()
            if (userSession == null) {
                call.respondRedirect("/login")
            } else {
                call.respondTemplate(
                    "booking.ftl", mapOf(
                        "navmenu" to navigationMenu
                    )
                )
            }
        }

        get("booking/my") {
            val userSession = call.sessions.get<UserSession>()
            if (userSession == null) {
                call.respondRedirect("/login")
            } else {
                call.respondTemplate(
                    "bookings_my.ftl", mapOf(
                        "navmenu" to navigationMenu
                    )
                )
            }
        }

        get("login") {
            call.respondTemplate("login.ftl", mapOf<String, Any>())
        }

        get("register") {
            call.respondTemplate("register.ftl", mapOf<String, Any>())
        }
    }
}

data class NavigationItem(
    val name: String,
    val addr: String
)