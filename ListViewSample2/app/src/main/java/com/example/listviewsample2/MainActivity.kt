package com.example.listviewsample2

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        // 1
        var menuList = mutableListOf("唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食", "唐揚げ 定食")

        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menuList) // 2

        lvMenu.adapter = adapter // 3

        // リストビューにリスナを設定
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    // リス名がタップされた時の処理が記述されたメンバクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // 注文確認ダイアログフラグメント作成
            val dialogFragment = OrderConfirmDialogFragment() // 1

            // ダイアログ表示
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment") // 2
        }
    }
}