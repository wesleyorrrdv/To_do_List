package com.curvelo.todolist.data

interface TaskRepository {
    fun getAllTasks(): List<Task>
    fun addTask(task:Task)
    fun updateTask(task:Task)
    fun deleteTask(task: Task)
}