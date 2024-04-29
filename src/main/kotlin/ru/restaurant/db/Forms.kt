package ru.restaurant.db

import org.jetbrains.exposed.sql.Table

object Forms : Table() {
    val id = integer("id").autoIncrement()
    val authorId = integer("authorId")
    val fullname = varchar("fullname", 128)
    var email = varchar("email", 128)
    var dateTime = varchar("dateTime", 64)
    var personsCount = integer("personsCount")
    var wishes = varchar("wishes", 1024)

    override val primaryKey = PrimaryKey(id)
}