package com.bangkit.idku.app.core.di

import com.bangkit.idku.app.core.data.repository.UserRepositoryImpl
import com.bangkit.idku.app.core.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {
    @Binds
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}