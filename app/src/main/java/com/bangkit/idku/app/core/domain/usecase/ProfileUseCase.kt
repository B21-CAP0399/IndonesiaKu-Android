package com.bangkit.idku.app.core.domain.usecase

import com.google.firebase.auth.FirebaseUser

interface ProfileUseCase {
    val user: FirebaseUser?
    fun logout()
}