package com.bangkit.idku.app.core.data.repository

import com.bangkit.idku.core.domain.model.LoggedInUser
import com.bangkit.idku.core.domain.repository.UserRepository
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl : UserRepository {
    private var user: LoggedInUser? = null

    override fun signUp(email: String, name: String, password: String, confirmPassword: String) {
        TODO("Not yet implemented")
    }

    override fun login(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun setLoggedInUser(loggedInUser: LoggedInUser) {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}