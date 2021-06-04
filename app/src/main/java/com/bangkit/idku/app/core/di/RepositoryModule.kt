package com.bangkit.idku.app.core.di

import com.bangkit.idku.app.core.data.repository.IdentityRepositoryImpl
import com.bangkit.idku.app.core.data.repository.UserRepositoryImpl
import com.bangkit.idku.app.core.domain.repository.IdentityRepository
import com.bangkit.idku.app.core.domain.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindsIdentityRepository(identityRepositoryImpl: IdentityRepositoryImpl): IdentityRepository
}