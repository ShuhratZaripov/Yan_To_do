package com.yourpackage.name.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    // Основной контейнер
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background) // Фон, если требуется
    ) {
        // Основная рамка (frame_1)
        Box(
            modifier = Modifier
                .size(width = 360.dp, height = 372.dp)
                .align(Alignment.TopStart) // Выравнивание слева и сверху
                .background(Color.LightGray) // Задай цвет, если нужен фон
        ) {
            // Здесь можно добавить содержимое основного фрейма, если требуется
        }

        // Кнопка (аналог buttons_flo)
        FloatingActionButton(
            onClick = { /* Действие на кнопку */ },
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.BottomEnd) // Выравнивание по нижнему правому углу
                .padding(end = 16.dp, bottom = 40.dp),
            elevation = FloatingActionButtonDefaults.elevation(5.dp) // Тень кнопки
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add Task") // Иконка для кнопки
        }

        // Нижняя полоса (аналог home_bar)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .align(Alignment.BottomCenter) // Выравнивание по центру внизу
                .background(Color.DarkGray) // Задай цвет, если нужен фон
        ) {
            // Добавь содержимое полосы, если оно предусмотрено
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
