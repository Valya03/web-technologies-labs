package ru.restaurant.db

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import ru.restaurant.db.DatabaseSingleton.dbQuery
import ru.restaurant.entity.UserEntity
import java.util.*

class UsersDaoImpl : UsersDao {

    private fun resultRowToUserEntity(row: ResultRow) = UserEntity(
        id = row[Users.id],
        username = row[Users.username],
        password = row[Users.password],
    )

    override suspend fun addNewUser(user: UserEntity) = dbQuery {
        val insertStatement = Users.insert {
            it[username] = user.username
            it[password] = user.password
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToUserEntity)
    }

    override suspend fun usernameExists(username: String) = dbQuery {
        Users
            .selectAll()
            .where { Users.username eq username }
            .map(::resultRowToUserEntity)
            .singleOrNull() != null
    }

    override suspend fun authUser(username: String, password: String) = dbQuery {
        Users
            .selectAll()
            .where { Users.username eq username }
            .map(::resultRowToUserEntity)
            .filter { it.password == password }
            .singleOrNull()
    }
}