package ru.restaurant.db

import ru.restaurant.entity.UserEntity


interface UsersDao {
    suspend fun addNewUser(user: UserEntity): UserEntity?
    suspend fun usernameExists(username: String): Boolean
    suspend fun authUser(username: String, password: String): UserEntity?
}