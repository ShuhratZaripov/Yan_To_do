package com.example.yan_to_do

import java.util.Date

data class TodoItem(
    val id: String,
    val text: String,
    val importance: String, // где Importance — это перечисление для важности
    val deadline: Date?,
    val isCompleted: Boolean,
    val createdAt: Date,
    val modifiedAt: Date?
)


enum class Importance {
    LOW, NORMAL, URGENT
}
