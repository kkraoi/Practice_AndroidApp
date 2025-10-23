package com.example.lifecyclesample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("ライフサイクルサンプル", "Sub は onCreate() を呼び起こした")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sub)
    }

    public override fun onStart() {
        Log.i("ライフサイクルサンプル", "Sub は onStart() を呼び起こした")
        super.onStart()
    }

    public override fun onRestart() {
        Log.i("ライフサイクルサンプル", "Sub は onRestart() を呼び起こした")
        super.onRestart()
    }

    public override fun onResume() {
        Log.i("ライフサイクルサンプル", "Sub は onResume() を呼び起こした")
        super.onResume()
    }

    public override fun onPause() {
        Log.i("ライフサイクルサンプル", "Sub は onPause() を呼び起こした")
        super.onPause()
    }

    public override fun onStop() {
        Log.i("ライフサイクルサンプル", "Sub は onStop() を呼び起こした")
        super.onStop()
    }

    public override fun onDestroy() {
        Log.i("ライフサイクルサンプル", "Sub は onDestroy() を呼び起こした")
        super.onDestroy()
    }

    // 「前の画面を表示」ボタンがタップされた時の処理
    fun onButtonClick(view: View) {
        // このアクティビティを終了させる
        finish()
    }
}