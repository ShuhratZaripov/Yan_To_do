package com.example.yan_to_do.repositories

import com.example.yan_to_do.api.TodoRequest
import com.example.yan_to_do.api.TodoResponse
import com.example.yan_to_do.models.TodoItem
import com.example.yan_to_do.network.ApiService
import com.example.yan_to_do.network.NetworkModule.createRetrofit
import com.example.yan_to_do.network.TokenProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class TaskRepository(private val tokenProvider: TokenProvider) {
    private val apiService: ApiService = createRetrofit(tokenProvider).create(ApiService::class.java)
    private val todoItemsList = mutableListOf<TodoItem>()
    val tasks: List<TodoItem> get() = todoItemsList.toList()
    private var revision: Int = 0

    // Метод для добавления задачи
    suspend fun addTask(todoItem: TodoItem, token: String): Response<TodoResponse> =
        withContext(Dispatchers.IO) {
            val todoRequest = TodoRequest(status = "ok", element = todoItem)
            apiService.postData(token = token, revision = revision, todoRequest = todoRequest)
        }

    // Метод для получения задач
    suspend fun getTasks(token: String): List<TodoItem> = withContext(Dispatchers.IO) {
        val response = apiService.getTasks(token)
        if (response.isSuccessful) {
            response.body()?.list ?: emptyList()
        } else {
            throw Exception("Error fetching tasks: ${response.message()}")
        }
    }

    // Метод для удаления задачи
    suspend fun removeTask(id: String, token: String) = withContext(Dispatchers.IO) {
        val response = apiService.deleteTask(id, token, revision)
        if (!response.isSuccessful) {
            throw Exception("Error deleting task: ${response.message()}")
        }
    }
}
