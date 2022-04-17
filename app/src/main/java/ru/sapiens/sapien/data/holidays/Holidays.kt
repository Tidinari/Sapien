package ru.sapiens.sapien.data.holidays

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

// Сущность в базе данных SQLite
// TODO: Прикрепить сущность к времени и дате
@Entity
data class Holidays(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val task: String,
    @ColumnInfo(name = "description") val desc: String?,
    @ColumnInfo(name = "date") val date: Date
)