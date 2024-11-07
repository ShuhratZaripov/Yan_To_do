package com.example.yan_to_do


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//import com.example.yan_to_do.components.TodoItemCell

@Composable
fun TodoListScreen() {
    val repository = remember { TodoItemsRepository() } // Создаем репозиторий задач
    val todoItems = repository.getAllTodoItems() // Получаем список задач

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Список задач", style = MaterialTheme.typography.headlineMedium)

        LazyColumn {
            items(todoItems) { todoItem ->
                TodoItemCell(todoItem) // Отображаем каждую задачу с помощью TodoItemCell
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        FloatingActionButton(onClick = { /* Добавить логику для добавления новой задачи */ }) {
            Text("+")
        }
    }
}
