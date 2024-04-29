package ru.restaurant.sessions

data class UserSession(
    val userId: Int,
    val token: String
)