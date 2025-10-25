package com.example.menusample

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // リストビューに表示するリストデータ
    private var _menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

    // SimpleAdapter の第４引数fromに使用するプロパティ
    private val _from = arrayOf("name", "price")

    // SimpleAdapterの第５引数toに使用するプロパティ
    private val _to = intArrayOf(R.id.tvMenuNameRow, R.id.tvMenuNameRow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 定食めにゅーListオブジェクトを、privateメソッドを利用して用意し、プロパティに格納
        _menuList = createTeishokuList()

        // 画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        // SimpleAdapterを生成
        val adapter = SimpleAdapter(this@MainActivity, _menuList, R.layout.row, _from, _to)

        // アダプタの登録
        lvMenu.adapter = adapter

        // リスナタップのリスナクラス登録
        lvMenu.onItemClickListener = ListItemClickListener()

        registerForContextMenu(lvMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // オプションメニュー用xmlファイルをインフレート
        menuInflater.inflate(R.menu.menu_options_menu_list, menu) // 1
        return true // 2
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 戻り値用の変数を初期値trueで用意
        var returnVal = true // 1

        // 選択されたメニューのIDのR値による処理の分岐
        when(item.itemId) { // 2
            R.id.menuListOptionTeishoku ->
                _menuList = createTeishokuList() // 3
            R.id.menuListOptionCurry ->
                _menuList = createCurryList() // 3
            else ->
                // 親クラスの同名メソッドを呼び出し
                returnVal = super.onOptionsItemSelected(item) // 4
        }

        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        val adapter = SimpleAdapter(this@MainActivity, _menuList, R.layout.row, _from, _to)
        lvMenu.adapter = adapter // 5

        return returnVal // 6
    }

    override fun onCreateContextMenu(menu: ContextMenu, view: View, menuInfo: ContextMenu.ContextMenuInfo) {
        // 親クラスの同名メソッドの呼び出し
        super.onCreateContextMenu(menu, view, menuInfo) // 1
        // コンテキストメニュー用 xmlファイルをインフレート
        menuInflater.inflate(R.menu.menu_options_menu_list, menu) // 2
        // コンテキストメニューのヘッダタイトルを設定
        menu.setHeaderTitle(R.string.menu_list_context_header) // 3
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // 戻り値用の変数
        var returnVal = true

        // 長押しされたビューに関する情報が格納されたオブジェクト
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo

        // 長押しされたリストのポジションを取得
        val listPosition = info.position

        // ポジションから長押しされたメニュー情報Mapオブジェクトを取得
        val menu = _menuList[listPosition]

        // 選択されたメニューのIDのR値による処理の分岐
        when(item.itemId) {
            // [説明を表示]メニューが選択されたときの処理
            R.id.menuListContextDesc -> {
                val desc = menu["desc"] as String
                // トーストを表示
                Toast.makeText(this@MainActivity, desc, Toast.LENGTH_SHORT).show()
            }
            R.id.menuListContextOrder ->
                order(menu)
            else ->
                returnVal = super.onContextItemSelected(item)
        }

        return returnVal
    }

    private fun createTeishokuList(): MutableList<MutableMap<String, Any>> {
        // 定食メニューリスト用のListオブジェクトを用意
        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

        // 「唐揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        var menu = mutableMapOf<String, Any>("name" to "唐揚げ定食", "price" to 800, "desc" to "唐揚げ唐揚げ唐揚げ唐揚げ唐揚げ唐揚げ唐揚げ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 850, "desc" to "ハンバーグハンバーグハンバーグハンバーグハンバーグハンバーグ")
        menuList.add(menu)

        return menuList
    }

    private fun createCurryList(): MutableList<MutableMap<String, Any>> {
        // カレーメニューリスト用のListオブジェクトを用意
        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

        //「ビーフカレー」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        var menu = mutableMapOf<String, Any>("name" to "ビィーフキャリー", "price" to 520, "desc" to "ビィーフキャリービィーフキャリービィーフキャリー")
        menuList.add(menu)

        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ポークカレー", "price" to 420, "desc" to "ポークカレーポークカレーポークカレー")
        menuList.add(menu)

        return menuList
    }

    private fun order(menu: MutableMap<String, Any>) {
        // 定食名と金額を取得。Mapの値部分がAny型なのでキャストが必要
        val menuName = menu["name"] as String
        val menuPrice = menu["price"] as Int

        // インテントオブジェクトを生成
        val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)

        // 第２画面に送るデールを格納
        intent2MenuThanks.putExtra("menuName", menuName)
        intent2MenuThanks.putExtra("menuPrice", "${menuPrice}円")

        // 第２画面の起動
        startActivity(intent2MenuThanks)
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            // タップされた行のデータを取得
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>
            // 注文処理
            order(item)
        }
    }
}