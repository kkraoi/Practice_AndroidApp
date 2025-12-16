package com.example.touchapp

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
         setContentView(R.layout.activity_main)

        val tvScore : TextView = findViewById(R.id.tvScrore)
        val btnMinus: Button = findViewById(R.id.btnMinus)
        val btnPlus: Button = findViewById(R.id.btnPlus)

        var num = 0;

        btnPlus.setOnClickListener {
            num += 1

            if(num == 5) {
                val intent = Intent(this, GameClear::class.java)
                startActivity(intent)
                finish()
            } else {
                tvScore.text = num.toString()
            }
        }

        btnMinus.setOnClickListener {
            num -= 1

            if(num == -5) {
                val intent = Intent(this, GameOver::class.java)
                startActivity(intent)
                finish()
            } else {
                tvScore.text = num.toString()
            }
        }
    }
}