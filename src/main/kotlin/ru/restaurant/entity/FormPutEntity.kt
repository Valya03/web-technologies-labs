package ru.restaurant.entity

data class FormPutEntity(
    var id: Int? = null,
    var fullname: String? = null,
    var email: String? = null,
    var dateTime: String? = null,
    var personsCount: Int? = null,
    var wishes: String? = null
)