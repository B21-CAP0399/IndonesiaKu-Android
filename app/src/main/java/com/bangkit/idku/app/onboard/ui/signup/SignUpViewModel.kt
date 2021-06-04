package com.bangkit.idku.app.onboard.ui.signup

import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.core.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    fun signUp(email: String, password: String, confirmPassword: String) =
        signUpUseCase.signUp(email, password, confirmPassword)

    fun signUpWithGoogle() = signUpUseCase.signUpWithGoogle()

}