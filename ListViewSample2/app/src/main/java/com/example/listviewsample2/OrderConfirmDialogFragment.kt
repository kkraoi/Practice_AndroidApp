package com.example.listviewsample2

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class OrderConfirmDialogFragment : DialogFragment() { // 1
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { // 2
        val dialog = activity?.let { // a
            val builder = AlertDialog.Builder(it) // 3
            builder.setTitle(R.string.dialog_title) // 4-1
            builder.setMessage(R.string.dialog_msg) // 4-2

            builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener()) // 5-1

            builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener()) // 5-2

            builder.setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickListener()) // 5-3

            builder.create() // 6
        }

        return dialog ?: throw IllegalStateException("アクティビティがnullです") // b
    }

    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface, which: Int) {
            var msg = ""

            when(which) { // 1
                DialogInterface.BUTTON_POSITIVE -> // 2-1
                    msg = getString(R.string.dialog_ok_toast)
                DialogInterface.BUTTON_NEGATIVE -> // 2-2
                    msg = getString(R.string.dialog_ng_toast)
                DialogInterface.BUTTON_NEUTRAL -> // 2-3
                    msg = getString(R.string.dialog_nu_toast)
            }

            Toast.makeText(activity, msg ,Toast.LENGTH_LONG).show()
        }
    }
}