package com.bangkit.idku.app.core.domain.usecase

import com.google.firebase.auth.FirebaseUser

interface HomeUseCase {
    val user: FirebaseUser?
    fun signOut()
}