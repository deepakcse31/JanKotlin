package com.example.jankotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentInfoDao {

    @Insert
    suspend fun insertStudentInfo(studentInfoData: StudentInfoData)

    @Query("SELECT * FROM student_info")
    suspend fun getAllStudentInfo(): List<StudentInfoData>

}