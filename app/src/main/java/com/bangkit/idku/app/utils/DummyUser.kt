package com.bangkit.idku.app.utils

import com.bangkit.idku.app.core.domain.model.UserAccount

object DummyUser {
    fun getUser() : UserAccount{
        return UserAccount("ahmad","ahmad@gmail.com",123456)
    }
}