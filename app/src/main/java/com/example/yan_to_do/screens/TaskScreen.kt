@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.yan_to_do.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.yan_to_do.models.TodoItem
import java.util.UUID

@Composable
fun TaskScreen(
    onAdd: (TodoItem) -> Unit,
    onBack: () -> Unit
) {
    var taskText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Task Screen") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Back")
                    }
                },
                actions = {
                    TextButton(onClick = {

                        val newTask = TodoItem(
                            id = UUID.randomUUID().toString(),
                            text = taskText,
                            importance = "LOW",
                            deadline = null,
                            isCompleted = false,
                            createdAt = System.currentTimeMillis().toString(),
                            changedAt = System.currentTimeMillis().toString(),
                            lastUpdatedBy = "Celeborn"
                        )
                        onAdd(newTask)
                        onBack()
                    }) {
                        Text("Save", color = MaterialTheme.colorScheme.primary)
                    }
                }
            )
        }
    ) { innerPadding ->
        TextField(
            value = taskText,
            onValueChange = { taskText = it },
            label = { Text("Task Description") },
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentHeight(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
            )
        )
    }
}
