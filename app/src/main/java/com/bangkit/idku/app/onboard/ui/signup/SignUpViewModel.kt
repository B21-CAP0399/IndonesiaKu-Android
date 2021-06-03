package com.bangkit.idku.app.onboard.ui.signup

import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.core.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val confirmPassword = MutableStateFlow("")

    fun signUp() = signUpUseCase.signUp(email.value, password.value, confirmPassword.value)

    fun signUpWithGoogle() = signUpUseCase.signUpWithGoogle()

}