package com.example.lovecolculater.model.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecolculater.model.Love

@Dao
interface LoveDao {
    @Insert
    fun insert(love:Love?)
    @Query("SELECT*FROM love_table ")
    fun getAll():List<Love>
    @Query("SELECT * FROM love_table ORDER BY id DESC")
    fun getAllSort(): List<Love>
}