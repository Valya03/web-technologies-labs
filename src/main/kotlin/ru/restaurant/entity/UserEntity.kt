package ru.restaurant.entity

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class UserEntity(
    val id: Int? = null,
    val username: String,
    val password: String
)