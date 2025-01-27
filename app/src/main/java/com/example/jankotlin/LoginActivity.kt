package com.example.jankotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    lateinit var edtphoneno: EditText
    lateinit var edtpassword: EditText
    lateinit var btnlogin: Button
    var phone: String = "8085429843"
    val password: String = "123456"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        edtphoneno = findViewById(R.id.edtphoneno)
        edtpassword = findViewById(R.id.edtpassword)
        btnlogin = findViewById(R.id.btnlogin)
        btnlogin.setOnClickListener {
            phone = "987654321"
            val phone = edtphoneno.text.toString()
            val password = edtpassword.text.toString()
            if (phone.isEmpty() || password.isEmpty()) {
                edtphoneno.error = "Please enter phone number"
                edtpassword.error = "Please enter password"
            } else {
                edtphoneno.error = null
                edtpassword.error = null
            }

            if (phone.length != 10) {
                edtphoneno.error = "Please enter valid phone number"
            } else {
                edtphoneno.error = null
            }
            if (password.length < 6) {
                edtpassword.error = "Please enter valid password"
            } else {
                edtpassword.error = null
            }
            if (phone.isNotEmpty() && password.isNotEmpty() && phone.length == 10 && password.length >= 6) {
                edtphoneno.error = null
                edtpassword.error = null
            }
            if (phone.equals("8085429843") && password.equals("123456"))
            {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}