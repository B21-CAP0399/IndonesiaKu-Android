package com.bangkit.idku.app.core.data.source.remote

import com.bangkit.idku.app.core.data.source.remote.network.IndonesiaKuServices

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class UserDataSource(
    private val indonesiaKuServices: com.bangkit.idku.app.core.data.source.remote.network.IndonesiaKuServices
) {


    fun authenticate(){

    }

    fun login(email: String, password: String) {
//        try {
//            val fakeUser = LoggedInUser(UUID.randomUUID().toString(), "Jane Doe")
//            return Result.Success(fakeUser)
//        } catch (e: Throwable) {
//            return Result.Error(IOException("Error logging in", e))
//        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}