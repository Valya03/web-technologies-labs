package ru.restaurant.plugins

import io.github.smiley4.ktorswaggerui.dsl.delete
import io.github.smiley4.ktorswaggerui.dsl.get
import io.github.smiley4.ktorswaggerui.dsl.post
import io.github.smiley4.ktorswaggerui.dsl.put
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import org.jetbrains.exposed.sql.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import kotlinx.css.body
import kotlinx.css.i
import kotlinx.css.q
import kotlinx.css.section
import ru.restaurant.db.FormsDao
import ru.restaurant.db.FormsDaoImpl
import ru.restaurant.entity.FormEntity
import java.util.Calendar
import java.util.Date

fun Application.configureRouting() {

    val dao: FormsDao = FormsDaoImpl()

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
            val form = kotlin.runCatching { call.receiveNullable<FormEntity>() }.getOrNull()
            if (form == null)
                call.response.status(HttpStatusCode.InternalServerError)
            else {
                dao.addNewForm(form)
                call.respondText("${form.fullname}, ваша заявка на ${form.personsCount} человек принята!")
            }
        }

        get("/api/form", {
            tags = listOf("form")
            description = "Get an application form by id"
            request {
                queryParameter<String>("id")
            }
            response {
                HttpStatusCode.OK to {
                    body<FormEntity>()
                }
            }
        }) {
            val id = call.request.queryParameters.getOrFail<Int>("id").toInt()
            call.respond(dao.form(id) ?: FormEntity())
        }

        put("/api/form", {
            tags = listOf("form")
            description = "Edit an application form"
            request {
                body<FormEntity> {
                    example(
                        "#1",
                        FormEntity(
                            id = 1,
                            fullname = "Иванов В.В.",
                            email = "ivanov@gmail.com",
                            dateTime = Date().toInstant().toString(),
                            personsCount = 2,
                            wishes = "Нет пожеланий"
                        )
                    )
                }
            }
            response {
                HttpStatusCode.OK to {
                    body<Boolean>()
                }
            }
        }) {
            val form = kotlin.runCatching { call.receiveNullable<FormEntity>() }.getOrNull()
            if (form == null)
                call.response.status(HttpStatusCode.InternalServerError)
            else {
                call.respond(dao.editForm(form).toString())
            }
        }

        delete("/api/form", {
            tags = listOf("form")
            description = "Delete an application form"
            request {
                queryParameter<Int>("id")
            }
            response {
                HttpStatusCode.OK to {
                    body<Boolean>()
                }
            }
        }) {
            val id = call.request.queryParameters.getOrFail<Int>("id").toInt()
            call.respond(dao.deleteForm(id).toString())
        }

        get("/api/all_forms", {
            tags = listOf("form")
            description = "Get all application forms"
            response {
                HttpStatusCode.OK to {
                    body<List<FormEntity>>()
                }
            }
        }) {
            call.respond(dao.allForms())
        }

    }
}
