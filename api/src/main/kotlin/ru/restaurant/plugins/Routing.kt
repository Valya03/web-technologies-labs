package ru.restaurant.plugins

import io.github.smiley4.ktorswaggerui.dsl.get
import io.github.smiley4.ktorswaggerui.dsl.post
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.body
import kotlinx.css.section
import ru.restaurant.entity.FormEntity
import java.util.Calendar
import java.util.Date

fun Application.configureRouting() {
    routing {

        get("/api/healthcheck", {
            description = "Check if method is up"
        }) {
            call.respondText("Hello World!")
        }

        post("/api/form", {
            tags = listOf("form")
            description = "Post an application form"
            request {
                body<FormEntity> {
                    example(
                        "#1",
                        FormEntity(
                            fullname = "Иванов В.В.",
                            email = "ivanov@gmail.com",
                            dateTime = Date().toInstant().toString(),
                            personsCount = 1,
                            wishes = "Нет пожеланий"
                        )
                    )
                }
            }
            response {
                HttpStatusCode.OK to {
                    body<String>()
                }
            }
        }) {
            val form = call.receive<FormEntity>()
            call.respondText("${form.fullname}, ваша заявка на ${form.personsCount} человек принята!")
        }
    }
}
