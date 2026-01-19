package com.example.jankotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var edtName : EditText
    lateinit var edtPassword : EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       edtName = findViewById(R.id.edtphone)
        edtPassword = findViewById(R.id.edtpassword)
        button=findViewById(R.id.btnlogin)
        GlobalScope.launch {
            log()
        }
        button.setOnClickListener {
            val name = edtName.text.toString()
            val password = edtPassword.text.toString()
            if (name == "8085429843" && password == "1234") {
                val intent = Intent(this, HomeActivty::class.java)
                startActivity(intent)
               // Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    suspend fun log()
    {
        Log.e("Data","Data"+"Data")
    }
}