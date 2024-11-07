package com.example.yan_to_do.designPages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yan_to_do.TodoItem
import com.example.yan_to_do.ui.theme.YanToDoTheme

@Composable
fun TaskScreen(task: TodoItem) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Заголовок задачи
        Text(text = task.text, style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        // Важность задачи
        Text(text = "Importance: ${task.importance}", style = MaterialTheme.typography.bodyLarge)

        // Дата выполнения задачи
        task.deadline?.let {
            Text(text = "Deadline: $it", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Отметка о выполнении задачи
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { /* здесь будет логика для изменения состояния задачи */ },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text = if (task.isCompleted) "Completed" else "Not Completed")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Кнопка для удаления задачи
        Button(
            onClick = { /* Логика для удаления задачи */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Delete Task", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Кнопка для редактирования задачи
        Button(
            onClick = { /* Логика для редактирования задачи */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Edit Task", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    YanToDoTheme {
        TaskScreen(
            task = TodoItem(
                id = "1",
                text = "Finish Jetpack Compose Tutorial",
                importance = "URGENT",
                deadline = null,
                isCompleted = false,
                createdAt = System.currentTimeMillis(),
                modifiedAt = null
            )
        )
    }
}
