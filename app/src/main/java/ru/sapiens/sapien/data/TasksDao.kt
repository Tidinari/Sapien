package ru.sapiens.sapien.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

// Data access object - объект, предоставляющий методы
// для манипуляции данных внутри SQLite базы данных.
@Dao
interface TasksDao {
    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Query("SELECT * FROM task WHERE uid IN (:tasksIds)")
    fun loadAllByIds(tasksIds: IntArray): List<Task>

    // TODO: Получать задачи по дате и времени

    @Deprecated(message = "Крайне небезопасный метод")
    @Query("SELECT * FROM task WHERE name LIKE :first AND " +
            "description LIKE :last LIMIT 1")
    fun findByName(first: String, last: String?): Task

    @Insert
    fun insertAll(vararg users: Task)

    @Delete
    fun delete(user: Task)
}