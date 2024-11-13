package com.example.yan_to_do.repositories

import androidx.compose.runtime.mutableStateListOf
import com.example.yan_to_do.models.Importance
import com.example.yan_to_do.models.TodoItem

object TodoItemsRepository {
    private val todoItems = mutableStateListOf<TodoItem>()

    init {
        repeat(20) { index ->
            val todoItem = TodoItem(
                id = System.currentTimeMillis().toInt().toString(),
                text = "Task $index",
                importance = when (index % 3) {
                    0 -> Importance.LOW
                    1 -> Importance.NORMAL
                    else -> Importance.HIGH
                }.toString(),
                deadline = if (index % 4 == 0) "March 1, 2024" else null,
                isCompleted = index % 5 == 0
            )
            todoItems.add(todoItem)
        }
    }

    fun getAllTodoItems(): List<TodoItem> = todoItems

    fun addTodoItem(todoItem: TodoItem) {
        todoItems.add(todoItem)
    }

    fun removeTodoItem(id: String) {
        todoItems.removeIf { it.id == id }
    }

    fun getValueById(id: String): TodoItem? {
        return todoItems.firstOrNull { it.id == id }
    }

}
