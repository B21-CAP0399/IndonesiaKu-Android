package com.bangkit.idku.app.core.domain.usecase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot

interface AuthenticationUseCase {
    fun getAccessRequest(id: String): Task<DocumentSnapshot>
}