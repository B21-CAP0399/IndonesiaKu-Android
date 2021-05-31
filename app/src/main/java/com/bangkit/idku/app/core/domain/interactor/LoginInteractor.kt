package com.bangkit.idku.app.core.domain.interactor

import com.bangkit.idku.app.core.domain.repository.UserRepository
import com.bangkit.idku.app.core.domain.usecase.LoginUseCase

class LoginInteractor(
    private val userRepository: UserRepository
) : LoginUseCase {
    override fun login(email: String, password: String) =
        userRepository.login(email, password)
}