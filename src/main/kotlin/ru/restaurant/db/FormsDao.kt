package ru.restaurant.db

import ru.restaurant.entity.FormEntity

interface FormsDao {
    suspend fun form(id: Int): FormEntity?
    suspend fun allForms(): List<FormEntity>
    suspend fun addNewForm(form: FormEntity): FormEntity
    suspend fun formsByAuthorId(authorId: Int): List<FormEntity>
    suspend fun deleteForm(id: Int): Boolean
    suspend fun editForm(form: FormEntity): Boolean
    suspend fun getFormAuthorId(formId: Int): Int
}