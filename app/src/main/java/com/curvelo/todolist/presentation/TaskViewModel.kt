package com.curvelo.todolist.presentation

import androidx.lifecycle.ViewModel
import com.curvelo.todolist.data.Task
import com.curvelo.todolist.domain.GetAllTasksUseCase

class TaskViewModel(private  val getAllTasksUseCase: GetAllTasksUseCase) : ViewModel() {
    fun getAllTasks():List<Task> = getAllTasksUseCase.execute()
}