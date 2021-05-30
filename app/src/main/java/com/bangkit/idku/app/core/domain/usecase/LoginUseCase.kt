package com.bangkit.idku.app.core.domain.usecase

interface LoginUseCase {
    fun login(email: String, password: String)
}