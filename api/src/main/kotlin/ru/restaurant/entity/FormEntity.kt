package ru.restaurant.entity

import com.google.gson.annotations.SerializedName

data class FormEntity(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("fullname") var fullname: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("dateTime") var dateTime: String? = null,
    @SerializedName("personsCount") var personsCount: Int? = null,
    @SerializedName("wishes") var wishes: String? = null
)
