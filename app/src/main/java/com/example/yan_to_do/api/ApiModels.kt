package com.example.yan_to_do.api

import com.example.yan_to_do.models.TodoItem

data class TodoResponse(
    val status: String,
    val revision: Int,
    val list: List<TodoItem>
)

data class TodoRequest(
    val status: String,
    val element: TodoItem
)
