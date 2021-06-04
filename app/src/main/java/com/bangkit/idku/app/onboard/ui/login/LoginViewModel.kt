package com.bangkit.idku.app.onboard.ui.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.core.domain.usecase.LoginUseCase
import com.bangkit.idku.app.utils.isEmailValid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    val user = loginUseCase.user
    fun login(email: String, password: String) = loginUseCase.login(email, password)
}