package com.example.fragmaentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
/**
 * A simple [Fragment] subclass.
 * Use the [MenuThanksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuThanksFragment : Fragment(R.layout.fragment_menu_thanks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 定食名と金額を取得
        val menuName = arguments?.getString("menuName") ?: "" // 1
        val menuPrice = arguments?.getString("menuPrice") ?: "" // 1

        // 定食名と金額を表示させるTextViewを取得
        val tvMenuName = view.findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = view.findViewById<TextView>(R.id.tvMenuPrice)

        // 戻るボタンを取得
        val btBackButton = view.findViewById<Button>(R.id.btThxBack)
        // 戻るボタンにリスナを登録
        btBackButton.setOnClickListener(ButtonClickListener())
    }

    // 「リストに戻る」ボタンが押されたときの処理が記述されたメンバクラス
    // private：外側のクラス（親・祖先）からしか使えないようにする。
    // inner：外側のクラス（親・祖先）にアクセスするため。
    // androidのイベントリスナーは引数に、関数を渡すのはNG、クラスを渡す。だから関数ではなくクラス。
    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            parentFragmentManager.popBackStack() // 2
        }
     }
}