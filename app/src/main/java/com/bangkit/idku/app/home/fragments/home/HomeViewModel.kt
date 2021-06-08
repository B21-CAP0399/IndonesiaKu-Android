package com.bangkit.idku.app.home.fragments.home

import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.core.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {
    val user = homeUseCase.user

    fun getIdentityServices() {

    }

    fun signOut() = homeUseCase.signOut()

}