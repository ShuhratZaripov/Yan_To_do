@file:Suppress("KotlinConstantConditions")

package com.example.yan_to_do

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TodoItemCell(todoItem: TodoItem) {
    // используйте todoItem.isCompleted вместо просто isCompleted
    val completed = todoItem.isCompleted
    // ... остальной код
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.Start
    ) {
        // Флаг выполнения задания
        Checkbox(
            checked = todoItem.isCompleted,
            onCheckedChange = null, // Замените на действие позже
            colors = CheckboxDefaults.colors(
                checkedColor = if ( todoItem.importance to Importance.URGENT) Color.Red else Color.Green
            )
        )

        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = todoItem.text,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            if (todoItem.deadline != null) {
                Text(
                    text = "Дедлайн: ${todoItem.deadline}",
                )
            }
        }
    }
}
