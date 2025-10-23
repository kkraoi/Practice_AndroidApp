package com.example.intentsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu) // 1-1
        // メニューリスト（MutableListオブジェクト）を用意
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf() // 1-2

        // メニューリストにメニュー（Mapオブジェクト）を代入 // 1-3
        var menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)

        // 繰り返し、メニューリストにメニューを入れる
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "800円")
        menuList.add(menu)

        // アダプター作成
        val from = arrayOf("name", "price") // 2-1
        val to = intArrayOf(android.R.id.text1, android.R.id.text2) // 2-2
        val adapter = SimpleAdapter(this@MainActivity, menuList, android.R.layout.simple_list_item_2, from, to) // 2-3

        // アダプター登録
        lvMenu.adapter = adapter // 3

        // リストタップのリスナクラスを登録
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    // リストがタップされた時の処理（メンバクラス）
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得。
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>

            // 定食名と金額を取得
            val menuName = item["name"]
            val menuPrice = item["price"]

            // インテントオブジェクト作成
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java) // 1

            // 第２画面に送るデータを格納
            intent2MenuThanks.putExtra("menuName", menuName) // 2
            intent2MenuThanks.putExtra("menuPrice", menuPrice)

            // 第二画面を起動
            startActivity(intent2MenuThanks) // 3
        }
    }
}