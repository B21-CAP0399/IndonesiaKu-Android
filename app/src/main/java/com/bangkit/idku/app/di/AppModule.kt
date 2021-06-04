package com.bangkit.idku.app.di

import com.bangkit.idku.app.core.domain.interactor.HomeInteractor
import com.bangkit.idku.app.core.domain.interactor.LoginInteractor
import com.bangkit.idku.app.core.domain.interactor.SignUpInteractor
import com.bangkit.idku.app.core.domain.usecase.HomeUseCase
import com.bangkit.idku.app.core.domain.usecase.LoginUseCase
import com.bangkit.idku.app.core.domain.usecase.SignUpUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsLoginUseCase(loginInteractor: LoginInteractor): LoginUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsSignUpUseCase(signUpInteractor: SignUpInteractor): SignUpUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsHomeUseCase(homeInteractor: HomeInteractor): HomeUseCase
}
