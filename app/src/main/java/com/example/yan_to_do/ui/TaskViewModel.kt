package com.example.yan_to_do.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yan_to_do.api.TodoRequest
import com.example.yan_to_do.models.TodoItem
import com.example.yan_to_do.network.ApiService
import com.example.yan_to_do.network.NetworkModule
import com.example.yan_to_do.network.TokenProvider
import com.example.yan_to_do.repositories.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(taskRepository: TaskRepository, private val tokenProvider: TokenProvider) : ViewModel() {

    private val apiService = NetworkModule.createRetrofit(tokenProvider).create(ApiService::class.java)

    private val _tasks = MutableStateFlow<List<TodoItem>>(emptyList())
    val tasks: StateFlow<List<TodoItem>> = _tasks

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun getTasks() {
        viewModelScope.launch {
            try {
                val token = "Celeborn"
                val tasks = apiService.getTasks(token)
                _tasks.value = tasks
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load tasks: ${e.message}"
            }
        }
    }

    fun addTask(todoItem: TodoItem) {
        viewModelScope.launch {
            try {
                val response = apiService.postData(
                    token = "Bearer ${tokenProvider.getToken()}",
                    revision = 0,
                    todoRequest = TodoRequest(status = "ok", element = todoItem)
                )
                if (response.isSuccessful) {

                    _tasks.value = response.body()?.list ?: emptyList()
                } else {
                    _errorMessage.value = "Error: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error: ${e.message}"
            }
        }
    }
}
