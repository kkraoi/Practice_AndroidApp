package com.example.recyclerviewsample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.databinding.ActivityMainBinding
import com.example.recyclerviewsample.databinding.RowBinding

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

        // RecyclerViewを取得 |5)-1-1
        val layout = LinearLayoutManager(this@MainActivity)

        // RecyclerViewにレイアウトマネージャーとしてLinearLayoutManagerを設定 |5)-1-2
        binding.rvMenu.layoutManager = layout

        // 定食メニューリストデータを生成
        val menuList = createTeishokuList()

        // アダプタオブジェクトを生成 |5)-2-1
        val adapter = RecyclerListAdapter(menuList)

        // RecyclerView にアダプタオブジェクトを設定 |5)-2-2
        binding.rvMenu.adapter = adapter

        // 区切り専用のオブジェクトを生成
        val decorator = DividerItemDecoration(this@MainActivity, layout.orientation)

        // RecyclerViewに区切り線オブジェクトを設定
        binding.rvMenu.addItemDecoration(decorator)
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

    // |4)-1
    private inner class RecyclerListAdapter(private val _listData: MutableList<MutableMap<String, Any>>): RecyclerView.Adapter<RecyclerListViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerListViewHolder {
            // レイアウトインフレータを取得 |4)-2-1
            val inflater = LayoutInflater.from(this@MainActivity)

            // row.xmlをインフレーとし、1行ぶんの画面部品とする |4)-2-2
            val view = inflater.inflate(R.layout.row, parent, false)

            // インフレートされた1行分の画面部品にリスナを設定
            view.setOnClickListener(ItemClickListener())

            // ビューホルダオブジェクトを生成 |4)-2-3
            val holder = RecyclerListViewHolder(view)

            // 生成したビューホルダをリターン |4)-2-4
            return holder
        }

        override fun onBindViewHolder(holder: RecyclerListViewHolder, position: Int) {
            // リストデータから該当1行分のデータを取得 |4)-3
            val item = _listData[position]

            // メニュー名の文字列を取得
            val menuName = item["name"] as String

            // メニュー金額を取得
            val menuPrice = item["price"] as Int

            // 表示ように金額を文字列に変換
            val menuPriceStr = menuPrice.toString()

            // メニュー名と金額をビューホルダ中のTextViewに設定
            holder._tvMenuNameRow.text = menuName
            holder._tvMenuPriceRow.text = menuPriceStr
        }

        override fun getItemCount(): Int {
            // リストデータの中の件数をリターン
            return _listData.size
        }
    }

    private inner class RecyclerListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rowBinding = RowBinding.bind(itemView)

        // リスト１行分の中でメニュー名を構成する画面部品　3-2-1
        var _tvMenuNameRow: TextView;

        // リスト１行分の中でメニューの金額を表示する画面部品 3-2-2
        var _tvMenuPriceRow: TextView;

        init {
            // 引数で渡されたリスト1行分の画面部品の中から表示に使われるTextViewを取得 3-3
            _tvMenuNameRow = rowBinding.tvMenuNameRow
            _tvMenuPriceRow = rowBinding.tvMenuPriceRow
        }
    }

    private inner class ItemClickListener: View.OnClickListener {
        override fun onClick(view: View) {
            val rowBiding = RowBinding.bind(view)

            // メニュー名表示　TextViewから表示されているメニュー名文字列を取得
            val menuName = rowBiding.tvMenuNameRow.text.toString()

            // トーストに表示する文字列を生成
            val msg = getString(R.string.msg_header) + menuName

            // トースト表示
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}