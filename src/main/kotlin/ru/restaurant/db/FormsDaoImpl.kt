package ru.restaurant.db

import ru.restaurant.entity.FormEntity
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import ru.restaurant.db.DatabaseSingleton.dbQuery

class FormsDaoImpl : FormsDao {

    private fun resultRowToFormEntity(row: ResultRow) = FormEntity(
        id = row[Forms.id],
        fullname = row[Forms.fullname],
        email = row[Forms.email],
        dateTime = row[Forms.dateTime],
        personsCount = row[Forms.personsCount],
        wishes = row[Forms.wishes]
    )

    override suspend fun form(id: Int): FormEntity? = dbQuery {
        Forms
            .selectAll().where { Forms.id eq id }
            .map(::resultRowToFormEntity)
            .singleOrNull()
    }

    override suspend fun allForms(): List<FormEntity> = dbQuery {
        Forms.selectAll().map { resultRowToFormEntity(it) }
    }

    override suspend fun addNewForm(form: FormEntity): FormEntity = dbQuery {
        val insertStatement = Forms.insert {
            it[Forms.fullname] = form.fullname.orEmpty()
            it[Forms.email] = form.email.orEmpty()
            it[Forms.dateTime] = form.dateTime.orEmpty()
            it[Forms.personsCount] = (form.personsCount ?: 0)
            it[Forms.wishes] = form.wishes.orEmpty()
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToFormEntity) ?: FormEntity()
    }

    override suspend fun deleteForm(id: Int): Boolean = dbQuery{
        Forms.deleteWhere{ Forms.id eq id } > 0
    }

    override suspend fun editForm(form: FormEntity): Boolean = dbQuery {
        Forms
            .update({ Forms.id eq (form.id ?: 0) }) {
                it[Forms.fullname] = form.fullname.orEmpty()
                it[Forms.email] = form.email.orEmpty()
                it[Forms.dateTime] = form.dateTime.orEmpty()
                it[Forms.personsCount] = (form.personsCount ?: 0)
                it[Forms.wishes] = form.wishes.orEmpty()
            } > 0
    }
}