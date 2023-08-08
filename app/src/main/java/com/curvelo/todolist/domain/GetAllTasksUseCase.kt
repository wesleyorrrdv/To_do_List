package com.curvelo.todolist.domain

import com.curvelo.todolist.data.Task
import com.curvelo.todolist.data.TaskRepository

class GetAllTasksUseCase(private val repository: TaskRepository) {
    fun execute(): List<Task> = repository.getAllTasks()
}