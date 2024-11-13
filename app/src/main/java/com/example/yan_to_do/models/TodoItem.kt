package com.example.yan_to_do.models

import java.util.Date

data class TodoItem(
    val id: String,
    var text: String,
    var importance: String?,
    var deadline: String? = null,
    var isCompleted: Boolean = false,
    var createdAt: String? = null,
    var modifiedAt: Date? = null
)
