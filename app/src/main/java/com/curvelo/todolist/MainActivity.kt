package com.curvelo.todolist

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.curvelo.todolist.data.Task
import com.curvelo.todolist.data.TaskRepositoryImpl
import com.curvelo.todolist.data.TaskViewModelFactory
import com.curvelo.todolist.domain.GetAllTasksUseCase
import com.curvelo.todolist.presentation.TaskViewModel
import com.curvelo.todolist.ui.theme.TodoListTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = TaskRepositoryImpl()
        val getAllTasksUseCase = GetAllTasksUseCase(repository)
        viewModel = ViewModelProvider(this, TaskViewModelFactory(getAllTasksUseCase))
            .get(TaskViewModel::class.java)

        setContent {
           TodoListTheme() {
                // Use Jetpack Compose UI components here
                TaskList(tasks = viewModel.getAllTasks())
            }
        }
    }
}


@Composable

fun TaskList(tasks: List<Task>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(tasks) { task ->
            TaskItem(task)
        }
    }
}

@Composable

fun TaskItem(task: Task) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = task.title,
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = task.description, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = if (task.isCompleted) "Completed" else "Not Completed",
            color = if (task.isCompleted) Color.Green else Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}