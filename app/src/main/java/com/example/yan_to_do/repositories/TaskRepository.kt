package com.example.yan_to_do.repositories

import com.example.yan_to_do.models.TodoItem
import com.example.yan_to_do.network.ApiService
import com.example.yan_to_do.network.NetworkModule.createRetrofit
import com.example.yan_to_do.network.TokenProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository(private val tokenProvider: TokenProvider) {
    private val apiService: ApiService = createRetrofit(tokenProvider).create(ApiService::class.java)

    suspend fun getTasks(): List<TodoItem> = withContext(Dispatchers.IO) {
        val token = tokenProvider.getToken()
        apiService.getTasks(token)
    }
}
