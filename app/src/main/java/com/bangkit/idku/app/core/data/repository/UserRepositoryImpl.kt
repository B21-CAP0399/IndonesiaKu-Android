package com.bangkit.idku.app.core.data.repository

import com.bangkit.idku.app.core.domain.repository.UserRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : UserRepository {
    override val user: FirebaseUser?
        get() = firebaseAuth.currentUser

    override fun signUp(email: String, password: String, confirmPassword: String) =
        firebaseAuth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task -> sendVerification(task) }


    override fun login(email: String, password: String) =
        firebaseAuth.signInWithEmailAndPassword(email, password)

    private fun sendVerification(task: Task<AuthResult>) =
        firebaseAuth.currentUser?.apply {
            sendEmailVerification().addOnCompleteListener {
                    if (task.isSuccessful) {
                        return@addOnCompleteListener
                    }
                }
        }


    override fun logout() = firebaseAuth.signOut()
}