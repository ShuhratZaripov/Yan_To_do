package com.example.yan_to_do.models

data class TodoItem(
    val id: String,
    val text: String,
    val importance: String?,
    val deadline: String?,
    val isCompleted: Boolean,
    val createdAt: String?,
    val changedAt: String?,
    val lastUpdatedBy: String?
)

