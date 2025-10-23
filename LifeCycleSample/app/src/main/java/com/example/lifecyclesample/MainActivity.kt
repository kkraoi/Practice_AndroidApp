package com.example.lifecyclesample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("ライフサイクルサンプル", "Main は onCreate() を呼び起こした")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    }

    public override fun onStart() {
        Log.i("ライフサイクルサンプル", "Main は onStart() を呼び起こした")
        super.onStart()
    }

    public override fun onRestart() {
        Log.i("ライフサイクルサンプル", "Main は onRestart() を呼び起こした")
        super.onRestart()
    }

    public override fun onResume() {
        Log.i("ライフサイクルサンプル", "Main は onResume() を呼び起こした")
        super.onResume()
    }

    public override fun onPause() {
        Log.i("ライフサイクルサンプル", "Main は onPause() を呼び起こした")
        super.onPause()
    }

    public override fun onStop() {
        Log.i("ライフサイクルサンプル", "Main は onStop() を呼び起こした")
        super.onStop()
    }

    public override fun onDestroy() {
        Log.i("ライフサイクルサンプル", "Main は onDestroy() を呼び起こした")
        super.onDestroy()
    }

    // 「次の画面を表示」ボタンがタップされた時の処理
    fun onButtonClick(view: View) {
        // インテントオブジェクトを用意
        val intent = Intent(this@MainActivity, SubActivity::class.java)

        // アクティビティを起動
        startActivity(intent)
    }
}