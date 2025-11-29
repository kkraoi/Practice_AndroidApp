package com.example.touchapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val tvName: TextView = findViewById(R.id.tvName)
        val btnBack: Button = findViewById(R.id.btnBack)

        val my_name = intent.getStringExtra("MY_NAME")
        tvName.text = my_name + "さん"

        btnBack.setOnClickListener {
            finish()
        }
    }
}