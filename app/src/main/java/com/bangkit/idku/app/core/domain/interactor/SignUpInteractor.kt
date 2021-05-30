package com.bangkit.idku.app.core.domain.interactor

import com.bangkit.idku.core.domain.repository.UserRepository
import com.bangkit.idku.core.domain.usecase.SignUpUseCase

class SignUpInteractor(
    private val userRepository: UserRepository
) : SignUpUseCase{
    override fun signUp(email: String, phoneNumber: String, password: String) {
        TODO("Not yet implemented")
    }
}