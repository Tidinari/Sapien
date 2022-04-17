package ru.sapiens.sapien.data.tasks

import androidx.room.Database
import androidx.room.RoomDatabase

// База данных сущности Task
@Database(entities = [Task::class], version = 1)
abstract class TasksDatabase: RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}