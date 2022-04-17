package ru.sapiens.sapien

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.sapiens.sapien.data.holidays.HolidaysDatabase
import ru.sapiens.sapien.data.tasks.TasksDatabase
import ru.sapiens.sapien.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Binding - для связывания происходящего в активити с кодом
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Показываем layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Навигация
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Не расскоментируй без объективной на то причины!
        // roomSetup()
    }

    // SQLite Database Setup
    private fun roomSetup() {
        val tasks = Room.databaseBuilder(
            applicationContext,
            TasksDatabase::class.java,
            "sapien-tasks"
        ).build()
        val holidays = Room.databaseBuilder(
            applicationContext,
            HolidaysDatabase::class.java,
            "sapien-tasks"
        ).build()
    }
}