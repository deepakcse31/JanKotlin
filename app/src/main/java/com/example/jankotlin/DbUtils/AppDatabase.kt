package com.example.jankotlin.DbUtils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jankotlin.StudentInfoDao
import com.example.jankotlin.StudentInfoData

@Database(entities = [StudentInfoData::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun studentInfoDao(): StudentInfoDao

}