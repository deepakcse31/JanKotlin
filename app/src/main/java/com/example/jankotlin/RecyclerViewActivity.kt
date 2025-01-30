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
import com.example.jankotlin.databinding.ActivityRecyclerViewBinding
import kotlinx.coroutines.launch

class RecyclerViewActivity : AppCompatActivity() {
   // lateinit var rvrecylerview : RecyclerView
    val db = MyApp.database
    lateinit var binding: ActivityRecyclerViewBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //rvrecylerview = findViewById(R.id.rvrecylerview)
        lifecycleScope.launch {
            val list = db.studentInfoDao().getAllStudentInfo()
            val recyclerViewAdapter=RecyclerViewAdapter(list)
            binding.rvrecylerview.adapter = recyclerViewAdapter
            binding.rvrecylerview.setHasFixedSize(true)
            binding.rvrecylerview.layoutManager = LinearLayoutManager(this@RecyclerViewActivity);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}