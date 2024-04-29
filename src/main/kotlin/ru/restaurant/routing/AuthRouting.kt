package ru.restaurant.routing

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.github.smiley4.ktorswaggerui.dsl.post
import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.css.body
import ru.restaurant.db.UsersDao
import ru.restaurant.db.UsersDaoImpl
import ru.restaurant.entity.FormEntity
import ru.restaurant.entity.UserEntity
import ru.restaurant.entity.UserPostEntity
import ru.restaurant.sessions.UserSession
import java.util.*

fun Routing.configureAuthRoutes(appConfig: HoconApplicationConfig) {

    val jwtSecret = appConfig.property("jwt.secret").getString()
    val jwtDomain = appConfig.property("jwt.issuer").getString()
    val jwtAudience = appConfig.property("jwt.audience").getString()
    val jwtRealm = appConfig.property("jwt.realm").getString()

    val usersDao: UsersDao = UsersDaoImpl()



    post("/api/login", {
        tags = listOf("auth")
        description = "Login"
        request {
            body<FormEntity> {
                example(
                    "#1",
                    UserPostEntity(
                        username = "peppy",
                        password = "qwerty123"
                    )
                )
            }
        }
        response {
            HttpStatusCode.OK to {
                body<String>()
            }
            HttpStatusCode.BadRequest to {
                body<String>()
            }
        }
    }) {
        val user = call.receive<UserEntity>()

        if (usersDao.usernameExists(user.username).not()) {
            call.respondText("Invalid username", status = HttpStatusCode.BadRequest)
        } else {
            val authUser = usersDao.authUser(user.username, user.password)

            if (authUser != null) {
                val token = JWT.create()
                    .withAudience(jwtAudience)
                    .withIssuer(jwtDomain)
                    .withClaim("username", authUser.username)
                    .withExpiresAt(Date(System.currentTimeMillis() + 60 * 1000))
                    .sign(Algorithm.HMAC256(jwtSecret))

                call.sessions.set(
                    UserSession(
                        userId = authUser.id ?: -1,
                        token = token.orEmpty()
                    )
                )
                call.respondRedirect("/")
            } else {
                call.respondText("Invalid password", status = HttpStatusCode.BadRequest)
            }
        }
    }



    post("/api/register", {
        tags = listOf("auth")
        description = "Register"
        request {
            body<FormEntity> {
                example(
                    "#1",
                    UserPostEntity(
                        username = "peppy",
                        password = "qwerty123"
                    )
                )
            }
        }
        response {
            HttpStatusCode.OK to {
                body<String>()
            }
            HttpStatusCode.BadRequest to {
                body<String>()
            }
        }
    }) {
        val user = call.receive<UserEntity>()

        if (usersDao.usernameExists(user.username).not()) {
            val authUser = usersDao.addNewUser(user)

            val token = JWT.create()
                .withAudience(jwtAudience)
                .withIssuer(jwtDomain)
                .withClaim("username", authUser?.username)
                .withExpiresAt(Date(System.currentTimeMillis() + 60 * 1000))
                .sign(Algorithm.HMAC256(jwtSecret))

            call.sessions.set(
                UserSession(
                    userId = authUser?.id ?: -1,
                    token = token.orEmpty()
                )
            )
            call.respondRedirect("/")
        } else {
            call.respondText("user with this username already exists", status = HttpStatusCode.BadRequest)
        }
    }



    get("/api/logout", {
        tags = listOf("auth")
        description = "Logout (clear cookies)"
        response {
            HttpStatusCode.OK to {
                body<String>()
            }
        }
    }) {
        call.sessions.clear<UserSession>()
        call.respondRedirect("/")
    }


}