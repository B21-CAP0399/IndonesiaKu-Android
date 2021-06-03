package com.bangkit.idku.app.core.domain.usecase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface SignUpUseCase {
    fun signUp(email: String, password: String, confirmPassword: String): Task<AuthResult>
    fun signUpWithGoogle()
}