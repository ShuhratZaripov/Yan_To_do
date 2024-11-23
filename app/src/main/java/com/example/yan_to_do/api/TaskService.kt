package com.example.yan_to_do.api

import com.example.yan_to_do.models.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TaskService {
    @GET("todo/list")
    suspend fun getTasks(
        @Header("Authorization") token: String): Response<PostResponse>
}
