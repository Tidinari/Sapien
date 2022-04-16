package ru.sapiens.sapien.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Сущность в базе данных SQLite
// TODO: Прикрепить сущность к времени и дате
@Entity
data class Task(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val task: String,
    @ColumnInfo(name = "description") val desc: String?
)
