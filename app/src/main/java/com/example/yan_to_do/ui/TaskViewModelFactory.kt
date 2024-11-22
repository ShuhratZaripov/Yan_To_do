package com.example.yan_to_do.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yan_to_do.network.TokenProvider
import com.example.yan_to_do.repositories.TaskRepository

class TaskViewModelFactory(
    private val taskRepository: TaskRepository,
    private val tokenProvider: TokenProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskViewModel(taskRepository, tokenProvider) as T
    }
}
