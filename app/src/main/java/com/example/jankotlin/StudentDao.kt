package com.example.jankotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: StudentData)

    @Query("SELECT * FROM student_data")
    suspend fun getAllStudents(): List<StudentData>

}