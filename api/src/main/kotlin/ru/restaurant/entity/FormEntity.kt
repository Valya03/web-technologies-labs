package ru.restaurant.entity

import com.google.gson.annotations.SerializedName

data class FormEntity(
    @SerializedName("fullname") var fullname: String?,
    @SerializedName("email") var email: String?,
    @SerializedName("dateTime") var dateTime: String?,
    @SerializedName("personsCount") var personsCount: Int?,
    @SerializedName("wishes") var wishes: String?
)
