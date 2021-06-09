package com.bangkit.idku.app.core.domain.interactor

import com.bangkit.idku.app.core.domain.repository.IdentityRepository
import com.bangkit.idku.app.core.domain.usecase.AuthenticationUseCase
import javax.inject.Inject

class AuthenticationInteractor @Inject constructor(
    private val identityRepository: IdentityRepository
): AuthenticationUseCase{
    override fun getAccessRequest(id: String) =
        identityRepository.getAccessRequest(id)

}