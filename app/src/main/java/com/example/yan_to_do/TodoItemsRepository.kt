package com.example.yan_to_do

class TodoItemsRepository {
    private val items = mutableListOf<TodoItem>()


    fun getItems(): List<TodoItem> {

        return items
    }

    fun addItem(item: TodoItem) {
        items.add(item)
    }

    fun removeItem(item: TodoItem) {
        items.remove(item)
    }

    fun getAllTodoItems() {

    }
}
