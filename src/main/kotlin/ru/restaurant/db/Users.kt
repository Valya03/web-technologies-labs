package ru.restaurant.db

import org.jetbrains.exposed.sql.Table
import ru.restaurant.db.Forms.autoIncrement
import ru.restaurant.db.Forms.integer
import ru.restaurant.db.Forms.varchar

object Users : Table() {
    val id = integer("id").autoIncrement()
    val username = varchar("username", 128)
    var password = varchar("password", 128)

    override val primaryKey = PrimaryKey(id)
}