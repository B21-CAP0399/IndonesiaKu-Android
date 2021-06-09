package com.bangkit.idku.app.home.fragments.scan

import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.core.domain.usecase.AuthenticationUseCase
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScanQRViewModel @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {
    fun getAccessRequest(id: String) = authenticationUseCase.getAccessRequest(id)
}