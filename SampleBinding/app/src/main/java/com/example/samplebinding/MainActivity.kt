package com.example.samplebinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samplebinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // binding変数を作成
    // lateinit：あとで初期化する宣言
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // layoutInflaterを渡してインスタンスを作る ＝ 初期化
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ↑
        // setContentView(R.layout.activity_main)
        // val helloText = findViewByID<Button>(R.id.tvHello)

        binding.tvHello.text = "こんにちわ。viewBinding"
    }
}