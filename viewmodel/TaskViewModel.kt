package com.example.week1kotlinperusteet.viewmodel

import androidx.lifecycle.ViewModel
import com.example.week1kotlinperusteet.data.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel : ViewModel() {

    private val allTasks = MutableStateFlow<List<Task>>(emptyList())
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())

    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    init {
        val initialTasks = listOf(
            Task(1, "Syö hedelmäsalaattia1", "jee", 4, "2026-01-20", false),
            Task(2, "Syö hedelmäsalaattia2", "jee", 2, "2026-01-26", true),
            Task(3, "Syö hedelmäsalaattia3", "jee", 3, "2026-01-30", false),
            Task(4, "Syö hedelmäsalaattia4", "jee", 2, "2026-02-20", true),
            Task(5, "Syö hedelmäsalaattia5", "jee", 1, "2026-03-13", false),
        )
        allTasks.value = initialTasks
        _tasks.value = initialTasks
    }

    fun addTask(task: Task) {
        allTasks.value = allTasks.value + task
        _tasks.value = allTasks.value
    }

    fun toggleDone(id: Int) {
        allTasks.value = allTasks.value.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
        _tasks.value = allTasks.value
    }

    fun removeTask(id: Int) {
        allTasks.value = allTasks.value.filterNot { it.id == id }
        _tasks.value = allTasks.value
    }

    fun filterByDone(done: Boolean) {
        _tasks.value = allTasks.value.filter { it.done == done }
    }

    fun sortByDueDate() {
        _tasks.value = _tasks.value.sortedBy { it.dueDate }
    }

    fun showAllTasks() {
        _tasks.value = allTasks.value
    }

    fun updateTask(updatedTask: Task) {
        _tasks.value = _tasks.value.map {
            if (it.id == updatedTask.id) updatedTask else it
        }
    }
}