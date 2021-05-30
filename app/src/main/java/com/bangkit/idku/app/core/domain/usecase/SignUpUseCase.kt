package com.bangkit.idku.app.core.domain.usecase

interface SignUpUseCase {
    fun signUp(email: String,phoneNumber: String, password: String)
}