package com.example.yan_to_do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yan_to_do.screens.MainScreen
import com.example.yan_to_do.screens.TaskScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(navController)
                }
                composable("task_screen") {
                    TaskScreen(
                        onAdd = {
                            // Логика для добавления задачи
                        },
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}
