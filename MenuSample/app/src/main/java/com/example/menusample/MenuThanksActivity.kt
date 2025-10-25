package com.example.menusample

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuThanksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_thanks)

        // リスト画面から渡されたデータを取得。
        val menuName = intent.getStringExtra("menuName")
        val menuPrice = intent.getStringExtra("menuPrice")

        // 定食名と金額を表示させるTextViewを取得。
        val tvMenuName = findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = findViewById<TextView>(R.id.tvMenuPrice)

        // TextViewに定食名と金額を表示。
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 元理知用の変数を初期値trueで用意
        var returnVal = true

        // 選択されたメニューが[戻る]の場合、アクティビティを終了
        if(item.itemId == android.R.id.home) { // 2
            finish()
        } else {
            returnVal = super.onOptionsItemSelected(item) // 2
        }

        return returnVal
    }

    /**
     * 戻るボタンをタップした時の処理。
     * @param view 画面部品。
     */
    fun onBackButtonClick(view: View) {
        finish()
    }
}