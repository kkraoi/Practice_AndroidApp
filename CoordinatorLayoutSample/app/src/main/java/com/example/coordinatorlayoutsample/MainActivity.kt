package com.example.coordinatorlayoutsample

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.coordinatorlayoutsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ツールバーにロゴを設定
        binding.toolbar.setLogo(R.mipmap.ic_launcher) // 1

        // アクションバーにツールバーを設定
        setSupportActionBar(binding.toolbar)

        // タイトルを変更
        binding.toolbarLayout.title = getString(R.string.toolbar_title)
        binding.toolbarLayout.setCollapsedTitleTextColor(Color.WHITE) // 縮小サイズ時の文字色


        // ツールバーにタイトル文字列流を設定
        binding.toolbar.setTitle(R.string.toolbar_title) // 2

        // ツールバーのタイトル文字色を設定
        binding.toolbar.setTitleTextColor(Color.WHITE) // 3

        // ツールバーのサブタイトルを設定
        binding.toolbar.setSubtitle(R.string.toolbar_subtitle) // 4

        // サブタイトルの文字色を設定
        binding.toolbar.setSubtitleTextColor(Color.LTGRAY) // 5

        setSupportActionBar(binding.toolbar)
    }
}