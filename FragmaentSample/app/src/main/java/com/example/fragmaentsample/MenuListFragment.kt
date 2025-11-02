package com.example.fragmaentsample


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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

        // リスナの登録
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得。SimpleAdapterでは1行分のデータはMutableMap型
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>

            // 定食名と金額を取得
            val menuName = item["name"]
            val menuPrice = item["price"]

            // 引き継ぎデータをまとめて格納できるBundleオブジェクトを生成
            val bundle = Bundle() // 1

            // Bundleオブジェクトに引き継ぎデータを格納
            bundle.putString("menuName", menuName) // 2
            bundle.putString("menuPrice", menuPrice) // 2

            // フラグメントトランザクションの開始
            // フラグメントトランザクション？：複数のフラグメント操作（追加・削除・置換など）を、1つのまとまり（取引）として実行する 仕組み
            val transaction = parentFragmentManager.beginTransaction() // 3
            // フラグメントトランザクションが正しく動作するように設定
            transaction.setReorderingAllowed(true) // 4
            // 現在の表示内容をバックスタックに追加
            // バックスタック？：フラグメントの操作履歴を蓄積する場所。Androidは「画面遷移の履歴」をスタック構造（LIFO：あと入れ先出し）で管理している。
            transaction.addToBackStack("Only List") // 5
            // fragmentMainContainerのフラグメントを注文完了フラグメントに置き換え。
            transaction.replace(R.id.fragmentMainContainer, MenuThanksFragment::class.java, bundle) // 6
            // フラグメントトランザクションのコミット
            transaction.commit() // 7
        }
    }
}