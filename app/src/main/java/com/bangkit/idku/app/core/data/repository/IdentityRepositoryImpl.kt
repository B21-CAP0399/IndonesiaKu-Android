package com.bangkit.idku.app.core.data.repository

import com.bangkit.idku.app.core.domain.repository.IdentityRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import javax.inject.Inject
import javax.inject.Singleton

class IdentityRepositoryImpl @Inject constructor(
    private val functions: FirebaseFunctions,
    private val db: FirebaseFirestore
) : IdentityRepository {
    override fun getIdentity(){

    }

    override fun getAccessRequest(id: String) =
        db.collection(accessPermission)
            .document(id)
            .get()


    companion object {
        private const val accessPermission = "access_permission"
    }
}