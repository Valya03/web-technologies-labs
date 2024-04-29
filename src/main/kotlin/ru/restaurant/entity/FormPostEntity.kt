package ru.restaurant.entity

data class FormPostEntity(
    var fullname: String? = null,
    var email: String? = null,
    var dateTime: String? = null,
    var personsCount: Int? = null,
    var wishes: String? = null
)