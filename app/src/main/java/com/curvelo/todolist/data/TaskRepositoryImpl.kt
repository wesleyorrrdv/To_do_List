package com.curvelo.todolist.data

class TaskRepositoryImpl:TaskRepository {

    private val tasks = mutableListOf<Task>()
    override fun getAllTasks(): List<Task> = tasks

    override fun addTask(task: Task){
tasks.add(task)
    }

    override fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(task: Task) {
   tasks.remove(task)
    }
}