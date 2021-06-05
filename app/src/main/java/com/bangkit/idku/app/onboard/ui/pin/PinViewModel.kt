package com.bangkit.idku.app.onboard.ui.pin

import androidx.lifecycle.ViewModel
import com.bangkit.idku.app.utils.DummyUser

class PinViewModel() : ViewModel() {
    fun getValidationPin(pinNumber : Int ) : Boolean{
        val userAccount = DummyUser.getUser()
        return userAccount.pin.equals(pinNumber)
    }
}