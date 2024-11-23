package com.example.yan_to_do


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yan_to_do.network.SharedPrefsTokenProvider
import com.example.yan_to_do.repositories.TaskRepository
import com.example.yan_to_do.screens.MainScreen
import com.example.yan_to_do.screens.TaskScreen
import com.example.yan_to_do.ui.TaskViewModel
import com.example.yan_to_do.ui.TaskViewModelFactory
import com.example.yan_to_do.viewModels.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val tokenProvider = SharedPrefsTokenProvider(this)
        val taskRepository = TaskRepository(tokenProvider)
        val taskViewModelFactory = TaskViewModelFactory(
            taskRepository = taskRepository,
            tokenProvider = tokenProvider
        )

        val taskViewModel = ViewModelProvider(this, taskViewModelFactory)[TaskViewModel::class.java]

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(
                        mainViewModel = mainViewModel,
                        navController = navController,
                        taskViewModel = taskViewModel
                    )
                }
                composable("task_screen") {
                    TaskScreen(
                        onAdd = { todoItem -> taskViewModel.addTask(todoItem) },
                        onBack = { navController.popBackStack() },
                        onDelete = { id -> taskViewModel.deleteTask(id) }
                    )
                }
            }
        }
    }
}


