package com.example.intentsample

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuThanksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_thanks)

        // リスト画面から渡されたデータを取得
        val menuName = intent.getStringExtra("menuName")
        val menuPrice = intent.getStringExtra("menuPrice")

        // 定食と金額を表示させるTextViewを取得
        val tvMenuName = findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = findViewById<TextView>(R.id.tvMenuPrice)

        // 定食名と金額をTextViewに表示
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice
    }

    // 戻るボタンをタップした時の処理
    fun onBackButtonClick(view: View) {
        finish()
    }
}