package com.curvelo.todolist.model

interface TaskRepository {
    fun getAllTasks(): List<Task>
    fun addTask(task:Task)
    fun updateTask(task:Task)
    fun deleteTask(task: Task)
}