package ru.restaurant.routing

import io.github.smiley4.ktorswaggerui.dsl.delete
import io.github.smiley4.ktorswaggerui.dsl.get
import io.github.smiley4.ktorswaggerui.dsl.post
import io.github.smiley4.ktorswaggerui.dsl.put
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.server.util.*
import ru.restaurant.db.FormsDao
import ru.restaurant.db.FormsDaoImpl
import ru.restaurant.entity.FormEntity
import ru.restaurant.entity.FormPostEntity
import ru.restaurant.entity.FormPutEntity
import ru.restaurant.sessions.UserSession
import java.util.Date

fun Routing.configureFormRoutes() {

    val formsDao: FormsDao = FormsDaoImpl()



    post("/api/form", {
        tags = listOf("form")
        description = "Post an application form"
        request {
            body<FormEntity> {
                example(
                    "#1",
                    FormPostEntity(
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
            HttpStatusCode.Unauthorized to {
                body<String>()
            }
        }
    }) {
        val userSession = call.sessions.get<UserSession>()
        if (userSession == null) {
            call.respondText("Not authenticated", status = HttpStatusCode.Unauthorized)
        } else {
            val form = kotlin.runCatching { call.receiveNullable<FormEntity>() }.getOrNull()
            if (form == null)
                call.response.status(HttpStatusCode.InternalServerError)
            else {
                formsDao.addNewForm(form.apply {
                    authorId = userSession.userId
                })
                call.respondText("${form.fullname}, ваша заявка на ${form.personsCount} человек принята!")
            }
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
        call.respond(formsDao.form(id) ?: FormEntity())
    }



    put("/api/form", {
        tags = listOf("form")
        description = "Edit an application form"
        request {
            body<FormEntity> {
                example(
                    "#1",
                    FormPutEntity(
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
            HttpStatusCode.Unauthorized to {
                body<String>()
            }
            HttpStatusCode.Forbidden to {
                body<String>()
            }
        }
    }) {
        val userSession = call.sessions.get<UserSession>()
        val form = call.receive<FormEntity>()

        if (userSession == null) {
            call.respondText("Not authenticated", status = HttpStatusCode.Unauthorized)
        } else if (userSession.userId == formsDao.getFormAuthorId(form.id ?: -1)) {
            call.respond(formsDao.editForm(form).toString())
        } else {
            call.respondText("Forbidden", status = HttpStatusCode.Forbidden)
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
            HttpStatusCode.Unauthorized to {
                body<String>()
            }
            HttpStatusCode.Forbidden to {
                body<String>()
            }
        }
    }) {
        val userSession = call.sessions.get<UserSession>()
        val id = call.request.queryParameters.getOrFail<Int>("id").toInt()

        if (userSession == null) {
            call.respondText("Not authenticated", status = HttpStatusCode.Unauthorized)
        } else if (userSession.userId == formsDao.getFormAuthorId(id)) {
            call.respond(formsDao.deleteForm(id).toString())
        } else {
            call.respondText("Forbidden", status = HttpStatusCode.Forbidden)
        }
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
        call.respond(formsDao.allForms())
    }



    get("/api/my_forms", {
        tags = listOf("form")
        description = "Get all application forms"
        response {
            HttpStatusCode.OK to {
                body<List<FormEntity>>()
            }
            HttpStatusCode.Unauthorized to {
                body<String>()
            }
        }
    }) {
        val userSession = call.sessions.get<UserSession>()
        if (userSession == null) {
            call.respondText("Not authenticated", status = HttpStatusCode.Unauthorized)
        } else {
            call.respond(formsDao.formsByAuthorId(userSession.userId))
        }
    }
}