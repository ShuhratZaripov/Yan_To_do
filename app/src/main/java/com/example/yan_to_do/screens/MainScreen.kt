package com.example.yan_to_do.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.yan_to_do.components.CurrentTask
import com.example.yan_to_do.components.CustomTitle
import com.example.yan_to_do.components.TasksLazyColumn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF7F6F2),
                    titleContentColor = Color(0xFFF7F6F2),
                ),
                title = {
                    CustomTitle(scrollBehavior.state.collapsedFraction > 0.5f)
                },
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    CurrentTask.currentTask = null
                    navController.navigate("task_screen") // Use "task_screen" for Task_Screen
                },
                shape = CircleShape,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .clip(CircleShape)
                    .shadow(10.dp),
                containerColor = Color(0xFF007AFF)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add task", tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        TasksLazyColumn(innerPadding, navController)
    }
}
