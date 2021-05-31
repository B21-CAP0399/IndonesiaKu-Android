package com.bangkit.idku.app.onboarding.ui.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.core.domain.usecase.LoginUseCase

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    // TODO: add stateflow or livedata for retaining form data

    fun login(email: String, password: String) {
        val result = loginUseCase.login(email, password)
        return result
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