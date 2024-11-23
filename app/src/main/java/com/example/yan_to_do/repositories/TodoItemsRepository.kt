package com.example.yan_to_do.repositories

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.yan_to_do.models.Importance
import com.example.yan_to_do.models.TodoItem

object TodoItemsRepository {
    var todoItemsList = mutableStateListOf<TodoItem>()
    fun getTodoItems(): SnapshotStateList<TodoItem> = todoItemsList

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
                isCompleted = index % 5 == 0,
                createdAt = System.currentTimeMillis().toString(), // Добавлено значение
                changedAt = System.currentTimeMillis().toString(), // Добавлено значение
                lastUpdatedBy = "System" // Добавлено значение
            )
            todoItemsList.add(todoItem)
        }
    }
    fun removeTask(id: String) {
        todoItemsList.removeIf { it.id == id }
    }


    fun getAllTodoItems(): List<TodoItem> = todoItemsList

    fun addTodoItem(todoItem: TodoItem) {
        todoItemsList.add(todoItem)
    }

    fun removeTodoItem(id: String) {
        todoItemsList.removeIf { it.id == id }
    }

    fun getValueById(id: String): TodoItem? {
        return todoItemsList.firstOrNull { it.id == id }
    }
}
