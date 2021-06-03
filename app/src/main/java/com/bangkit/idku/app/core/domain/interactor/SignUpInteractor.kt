package com.bangkit.idku.app.core.domain.interactor

import com.bangkit.idku.app.core.domain.repository.UserRepository
import com.bangkit.idku.app.core.domain.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpInteractor @Inject constructor(
    private val userRepository: UserRepository
) : SignUpUseCase {
    override fun signUp(email: String, password: String, confirmPassword: String) =
        userRepository.signUp(email, password, confirmPassword)


    override fun signUpWithGoogle() {
        TODO("Not yet implemented")
    }
}