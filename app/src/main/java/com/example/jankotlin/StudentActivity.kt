package com.example.jankotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class StudentActivity : AppCompatActivity() {
    lateinit var edEnrollmentno: EditText
    lateinit var edUserName: EditText
    lateinit var btnSubmit: Button
    val db = MyApp.database
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student)
        edEnrollmentno = findViewById(R.id.edEnrollmentno)
        edUserName = findViewById(R.id.edUserName)
        btnSubmit = findViewById(R.id.btnsubmit)

        btnSubmit.setOnClickListener {
            val enrollmentno = edEnrollmentno.text.toString()
            val username = edUserName.text.toString()
            lifecycleScope.launch {
                db.studentInfoDao().insertStudentInfo(StudentInfoData(userName = username, enroll = enrollmentno))
                edEnrollmentno.text.clear()
                edUserName.text.clear()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}