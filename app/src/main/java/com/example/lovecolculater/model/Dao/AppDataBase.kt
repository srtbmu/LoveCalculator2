package com.example.lovecolculater.model.Dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecolculater.model.Love

@Database(entities = [Love::class], version = 1, exportSchema = false)
 abstract class AppDataBase:RoomDatabase() {
     abstract fun loveDao(): LoveDao
}