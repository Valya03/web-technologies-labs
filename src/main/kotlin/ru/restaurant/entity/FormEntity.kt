package ru.restaurant.entity

import com.google.gson.annotations.SerializedName

data class FormEntity(
    var id: Int? = null,
    var authorId: Int? = null,
    var fullname: String? = null,
    var email: String? = null,
    var dateTime: String? = null,
    var personsCount: Int? = null,
    var wishes: String? = null
)
