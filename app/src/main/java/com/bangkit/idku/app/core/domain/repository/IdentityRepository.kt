package com.bangkit.idku.app.core.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot

interface IdentityRepository {
    fun getIdentity()
    fun getAccessRequest(id: String): Task<DocumentSnapshot>
}