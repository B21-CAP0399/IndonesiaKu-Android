package com.bangkit.idku.core.domain.repository

import com.bangkit.idku.core.data.model.LoggedInUser

interface UserRepository {
    fun signin(username: String, name: String, password: String, confirmPassword: String)
    fun login(username: String, password: String)
    fun setLoggedInUser(loggedInUser: LoggedInUser)
    fun logout()
}