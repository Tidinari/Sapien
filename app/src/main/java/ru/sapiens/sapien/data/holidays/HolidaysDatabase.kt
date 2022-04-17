package ru.sapiens.sapien.data.holidays

import androidx.room.Database
import androidx.room.RoomDatabase

// База данных сущности Task
@Database(entities = [Holidays::class], version = 1)
abstract class HolidaysDatabase: RoomDatabase() {
    abstract fun holidaysDao(): HolidaysDao
}