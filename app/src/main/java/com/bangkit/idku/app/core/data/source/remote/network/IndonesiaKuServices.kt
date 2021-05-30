package com.bangkit.idku.app.core.data.source.remote.network

import retrofit2.http.POST

interface IndonesiaKuServices {
    @POST
    fun login()

    @POST
    fun signup()

    @POST
    fun auth()
}