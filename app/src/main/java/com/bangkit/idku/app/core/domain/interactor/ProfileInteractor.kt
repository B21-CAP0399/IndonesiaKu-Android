package com.bangkit.idku.app.core.domain.interactor

import com.bangkit.idku.app.core.domain.repository.UserRepository
import com.bangkit.idku.app.core.domain.usecase.ProfileUseCase
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class ProfileInteractor @Inject constructor(
    private val userRepository: UserRepository
) : ProfileUseCase {
    override val user: FirebaseUser?
        get() = userRepository.user

    override fun logout() = userRepository.logout()
}