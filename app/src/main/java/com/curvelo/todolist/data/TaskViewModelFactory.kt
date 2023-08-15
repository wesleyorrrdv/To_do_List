package com.curvelo.todolist.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.curvelo.todolist.domain.GetAllTasksUseCase
import com.curvelo.todolist.presentation.TaskViewModel

class TaskViewModelFactory(private  val getAllTasksUseCase: GetAllTasksUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)){
            return TaskViewModel(getAllTasksUseCase) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")

    }
}