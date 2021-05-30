package com.bangkit.idku.app.core.di

import com.bangkit.idku.app.BuildConfig
import com.bangkit.idku.app.core.data.source.remote.network.IndonesiaKuServices
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object RemoteModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .retryOnConnectionFailure(false)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
            })
            .build()

    @Provides
    fun ProvideIDkuServices(okHttpClient: OkHttpClient): IndonesiaKuServices =
        Retrofit.Builder()
            .baseUrl("")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IndonesiaKuServices::class.java)

}