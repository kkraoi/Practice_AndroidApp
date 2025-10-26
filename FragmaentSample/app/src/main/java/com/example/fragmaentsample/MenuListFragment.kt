package com.example.fragmaentsample


import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment

// Fragment()：引数にR値のlayoutIDを入れることで、fragment_menu_list.xmlを使うと伝えている。
class MenuListFragment : Fragment(R.layout.fragment_menu_list) { // 1
    // フラグメントビューが生成された直後（ライフサイクル）に発火する。
    // View => XMLから生成された「このフラグメントのルートビュー」そのもの。UI操作に使う。
    // Bundle? => 以前の状態を保持するデータ。画面回転や再生成時に復元される。
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // 2
        // 親クラス（Fragment）のメソッドを呼び出している。
        super.onViewCreated(view, savedInstanceState) // 3

        // 画面部品ListViewを取得
        val lvMenu = view.findViewById<ListView>(R.id.lvMenu)

        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()

        var menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)

        // SimpleAdapter第４引数from用データの用意
        val from = arrayOf("name","price")
        // SimpleAdapter第５引数to用データの用意
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        // SimpleAdapterを生成
        val adapter =
            SimpleAdapter(activity, menuList, android.R.layout.simple_list_item_2, from, to)

        lvMenu.adapter = adapter
    }
}