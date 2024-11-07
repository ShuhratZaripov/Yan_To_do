package com.example.yan_to_do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Устанавливаем контент приложения
        setContent {
            MyApp() // Вызов функции, которая задает интерфейс приложения
        }
    }
}

@Composable
fun MyApp() {
    // Используем MaterialTheme для стилизации приложения
    MaterialTheme {
        // Обеспечиваем фон приложения с помощью Surface
        Surface {
            TodoListScreen() // Отображаем экран списка задач
        }
    }
}
