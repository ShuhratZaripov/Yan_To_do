package com.example.yan_to_do.network

import com.example.yan_to_do.api.TodoRequest
import com.example.yan_to_do.api.TodoResponse
import com.example.yan_to_do.models.TodoItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("todo/list")
    suspend fun getData(
        @Header("Authorization") token: String
    ): Response<TodoResponse>

    @POST("todo/list")
    suspend fun postData(
        @Header("Authorization") token: String,
        @Header("X-Last-Known-Revision") revision: Int,
        @Body todoRequest: TodoRequest
    ): Response<TodoResponse>

    @PUT("todo/list/{id}")
    suspend fun updateTask(
        @Path("id") id: String,
        @Header("Authorization") token: String,
        @Header("X-Last-Known-Revision") revision: Int,
        @Body todoRequest: TodoRequest
    ): Response<TodoResponse>

    @DELETE("todo/list/{id}")
    suspend fun deleteTask(
        @Path("id") id: String,
        @Header("Authorization") token: String,
        @Header("X-Last-Known-Revision") revision: Int
    ): Response<TodoResponse>

    fun getTasks(token: String): List<TodoItem>
}
