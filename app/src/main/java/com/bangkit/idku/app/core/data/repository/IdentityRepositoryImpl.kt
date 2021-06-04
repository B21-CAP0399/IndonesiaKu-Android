package com.bangkit.idku.app.core.data.repository

import com.bangkit.idku.app.core.data.source.remote.network.IndonesiaKuServices
import com.bangkit.idku.app.core.domain.repository.IdentityRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IdentityRepositoryImpl @Inject constructor(
) : IdentityRepository {
    override fun getIdentity() {
        TODO("Not yet implemented")
    }
}