package ru.sapiens.sapien.data.holidays

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.sql.Date

// Data access object - объект, предоставляющий методы
// для манипуляции данных внутри SQLite базы данных.
@Dao
interface HolidaysDao {
    @Query("SELECT * FROM task")
    suspend fun getAll(): List<Holidays>

    @Query("SELECT * FROM task WHERE uid IN (:tasksIds)")
    suspend fun loadAllByIds(tasksIds: IntArray): List<Holidays>

    @Query("SELECT * FROM task WHERE date LIKE :date LIMIT 1")
    suspend fun findByDate(date: Date): Holidays

    @Insert
    suspend fun insertAll(vararg users: Holidays)

    @Delete
    suspend fun delete(user: Holidays)
}