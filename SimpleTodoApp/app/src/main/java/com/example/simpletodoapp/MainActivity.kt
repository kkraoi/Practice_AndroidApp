package com.example.simpletodoapp

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Viewを取得
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val lv: ListView = findViewById(R.id.lv)

        // アダプターに入れてListViewにセット
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf() // 最初のリストは空っぽ
        )

        lv.adapter = adapter

        // スマホ内部のストレージから読み取ってListViewに反映する。データ様式はxmlだ。/data/user/0/com.example.simpletodoapp/shared_prefs/todo_prefs.xml"が正体だ。
//        <map>
//          <string name="todo_list">買い物\n勉強\n洗濯</string>
//        </map>
//        みたいな感じで保存される。
        // ShearedPreferencesとは：Android標準の小さな設定やデータを保存する仕組み。
        // MODE_PRIVATE:他アプリからは見えないにするモード。
        val pref = getSharedPreferences("todo_prefs", MODE_PRIVATE)
        val savedTodos = pref.getString("todo_list", "")
        if (!savedTodos.isNullOrEmpty()) { //
            // addAll内はcollectionになる。
            adapter.addAll(savedTodos.split("\n"))
        }

        // +ボタンでアラートダイアログ
        btnAdd.setOnClickListener {
            // EditTextのインスタンスを作る
            val et = EditText(this)

            AlertDialog.Builder(this)
                .setTitle("項目の追加")
                .setMessage("何をする")
                .setView(et)
                .setPositiveButton("追加", DialogInterface.OnClickListener { dialogInterface, i ->
                    // add()アダプターに追加する
                    val myTodo = et.text.toString()
                    adapter.add(myTodo)

                    // ???
                    val pref = getSharedPreferences("todo_prefs", MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putString("todo_list", adapter.getAllItemsAsString())
                    editor.apply()
                })

                .setNegativeButton("キャンセル", null)
                .show()
        }

        // ListViewをタッチしたらアラートダイアログ
        lv.setOnItemClickListener { adapterView, view, i, l ->
            AlertDialog.Builder(this)
                .setTitle("削除しますか")
                .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                    adapter.remove(adapter.getItem(i))
                    adapter.notifyDataSetChanged() // 画面を更新する

                    // ???
                    //
                    val pref = getSharedPreferences("todo_prefs", MODE_PRIVATE)
                    pref.edit().putString("todo_list", adapter.getAllItemsAsString()).apply()
                })
                .setNegativeButton("No", null)
                .show()
        }
    }
}

// ArrayAdapterに追加する関数。
fun ArrayAdapter<String>.getAllItemsAsString(): String {
    val items = mutableListOf<String>()
    for (i in 0 until count) {
        items.add(getItem(i) ?: "")
    }
    return items.joinToString("\n")
}