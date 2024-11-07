package com.example.yan_to_do

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import java.util.UUID
import androidx.compose.ui.Modifier


@Composable
fun TodoItemView(todoItem: TodoItem) {
    val backgroundColor = when {
        todoItem.isCompleted -> Color.GREEN
        todoItem.importance == Importance.URGENT -> Color.RED
        else -> Color.TRANSPARENT
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(androidx.compose.ui.graphics.Color.Black)
        .padding(16.dp)) {
        Text(text = todoItem.text, maxLines = 3, overflow = TextOverflow.Ellipsis)
    }
}
@Composable
fun TodoListScreen(repository: TodoItemsRepository) {
    val items = repository.getItems()

    LazyColumn {
        items(items) { item ->
            TodoItemView(todoItem = item)
        }
    }
}
@Composable
fun AddTodoScreen(onAdd: (TodoItem) -> Unit) {
    var text by remember { mutableStateOf("") }
    var importance by remember { mutableStateOf(Importance.NORMAL) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = text, onValueChange = { text = it }, label = { Text("Описание") })
        // Добавь другие поля для выбора дедлайна и важности
        Button(onClick = {
            onAdd(TodoItem(id = UUID.randomUUID().toString(), text = text, importance = importance, isCompleted = false, createdAt = Date()))
        }) {
            Text("Сохранить")
        }
    }
}
