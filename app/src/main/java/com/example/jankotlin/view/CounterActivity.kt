package com.example.jankotlin.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.jankotlin.R
import com.example.jankotlin.viewModel.CounterViewModel

class CounterActivity : AppCompatActivity() {
    lateinit var tvText: TextView
    lateinit var btnAdd: Button

    lateinit var counterViewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_counter)
        tvText = findViewById(R.id.tvtext)
        btnAdd = findViewById(R.id.btnAdd)
        counterViewModel= ViewModelProvider(this).get(CounterViewModel::class.java)

        counterViewModel.count.observe(this) {
            tvText.text = it.toString()
        }

        btnAdd.setOnClickListener {
            counterViewModel.add()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}