package com.bangkit.idku.app.core.domain.repository

import com.bangkit.idku.app.core.domain.model.LoggedInUser

interface UserRepository {
    fun signUp(email: String, name: String, password: String, confirmPassword: String)
    fun login(email: String, password: String)
    fun setLoggedInUser(loggedInUser: LoggedInUser)
    fun logout()
}