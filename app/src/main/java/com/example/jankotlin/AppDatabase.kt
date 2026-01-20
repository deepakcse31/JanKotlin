package com.example.jankotlin

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [StudentData::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun studentDao(): StudentDao
}