package com.bangkit.idku.app.onboard.ui.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.core.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    // TODO: add stateflow or livedata for retaining form data

    fun login(email: String, password: String) {
        return loginUseCase.login(email, password)
    }

    // A placeholder username validation check
    private fun isEmailAddressValid(username: String): Boolean =
        if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean =
        password.length > 8

    private fun isPhoneNumberValid(phoneNumber: String): Boolean =
        Patterns.PHONE.matcher(phoneNumber).matches()


}