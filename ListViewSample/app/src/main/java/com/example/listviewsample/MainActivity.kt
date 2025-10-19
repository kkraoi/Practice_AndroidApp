package com.example.listviewsample

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu) // 1
        lvMenu.onItemClickListener = ListItemClickListener() // 2
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener { // 1
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) { //2
            val item = parent.getItemAtPosition(position) as String //3
            val show = "あなたが選んだ定食： $item" // 4

            Toast.makeText(this@MainActivity, show, Toast.LENGTH_LONG).show() // 5
        }
    }
}