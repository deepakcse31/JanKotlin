package com.example.jankotlin

import android.app.Application
import androidx.room.Room
import com.example.jankotlin.DbUtils.AppDatabase

class MyApp : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this, AppDatabase::class.java, "my_db").build()
    }
}