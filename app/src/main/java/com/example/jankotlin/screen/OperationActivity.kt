package com.example.jankotlin.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.jankotlin.R
import com.example.jankotlin.databinding.ActivityOperationBinding
import com.example.jankotlin.viewmodel.OperationViewModel
import kotlinx.coroutines.launch

class OperationActivity : AppCompatActivity() {
    lateinit var binding : ActivityOperationBinding
    val operationViewModel : OperationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_operation)
        binding = ActivityOperationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationViewModel.result.observe(this){
            binding.tvresult.text = it
        }

        binding.btnadd.setOnClickListener {
            val a = binding.edtno1.text.toString().toInt()
            val b = binding.edtno2.text.toString().toInt()
            lifecycleScope.launch {
                operationViewModel.performOperation(a,b)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}