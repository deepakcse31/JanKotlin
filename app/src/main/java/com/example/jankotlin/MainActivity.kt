package com.example.jankotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.jankotlin.view.CounterActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
      lateinit var edtName: EditText
      lateinit var edtRollNo: EditText
      lateinit var edtBranch: EditText
      lateinit var edtSem: EditText
      lateinit var btnSubmit: Button
    lateinit var viewAll : TextView
      val database = MyApp.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        edtName = findViewById(R.id.edtname)
        edtRollNo = findViewById(R.id.edtrollno)
        edtBranch = findViewById(R.id.edtbranch)
        edtSem = findViewById(R.id.edtsem)
        btnSubmit = findViewById(R.id.btnSubmit)



        btnSubmit.setOnClickListener {
            val intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)

//            val name = edtName.text.toString()
//            val rollNo = edtRollNo.text.toString()
//            val branch = edtBranch.text.toString()
//            val sem = edtSem.text.toString()
//            lifecycleScope.launch {
//                database.studentDao().insertStudent(StudentData(name = name, rollNo = rollNo, branch = branch, semester = sem))
//                Toast.makeText(this@MainActivity, "Data Inserted", Toast.LENGTH_SHORT).show()
//
//            }
//            edtName.text.clear()
//            edtRollNo.text.clear()
//            edtBranch.text.clear()
//            edtSem.text.clear()

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}