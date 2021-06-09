package com.bangkit.idku.app.di

import com.bangkit.idku.app.core.domain.interactor.*
import com.bangkit.idku.app.core.domain.usecase.*
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

    @Binds
    @ViewModelScoped
    abstract fun bindsAuthenticationUseCase(authenticationInteractor: AuthenticationInteractor): AuthenticationUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsProfileUseCase(profileInteractor: ProfileInteractor): ProfileUseCase
}
