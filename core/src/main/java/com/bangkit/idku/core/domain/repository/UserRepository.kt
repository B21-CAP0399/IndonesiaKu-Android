package com.bangkit.idku.core.domain.repository

interface UserRepository {
    fun signin()
    fun login()
    fun setLoggedInUser()
    fun logout()
}