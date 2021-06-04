package com.bangkit.idku.app.core.domain.interactor

import com.bangkit.idku.app.core.domain.repository.IdentityRepository
import com.bangkit.idku.app.core.domain.repository.UserRepository
import com.bangkit.idku.app.core.domain.usecase.HomeUseCase
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val userRepository: UserRepository,
    private val identityRepository: IdentityRepository
): HomeUseCase{
    override val user: FirebaseUser?
        get() = userRepository.user
}