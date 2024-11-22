package com.example.yan_to_do.network

import com.example.yan_to_do.api.TaskService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://hive.mrdekk.ru/"

    fun createRetrofit(tokenProvider: TokenProvider): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(tokenProvider))
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    fun createTaskService(): TaskService {
        return createRetrofit().create(TaskService::class.java)
    }
}
