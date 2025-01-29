package com.example.jankotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var rvrecylerview : RecyclerView
    val db = MyApp.database

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        rvrecylerview = findViewById(R.id.rvrecylerview)
        lifecycleScope.launch {

            val list = db.studentInfoDao().getAllStudentInfo()

            Log.e("Recyclerview_data","Recyclerview_data"+list)
            val recyclerViewAdapter=RecyclerViewAdapter(list)
            rvrecylerview.adapter = recyclerViewAdapter
            rvrecylerview.setHasFixedSize(true)
            rvrecylerview.layoutManager = LinearLayoutManager(this@RecyclerViewActivity);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}