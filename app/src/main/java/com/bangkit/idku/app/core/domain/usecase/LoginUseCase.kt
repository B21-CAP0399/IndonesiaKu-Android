package com.bangkit.idku.app.core.domain.usecase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

interface LoginUseCase {
    val user: FirebaseUser?
    fun login(email: String, password: String): Task<AuthResult>
    fun loginWithGoogle()
}