package com.example.random

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.example.random.databinding.DialogInputItemFragmentBinding

class InputItemDialog(val name: String? = null, val callback: (String) -> Unit): DialogFragment(), View.OnClickListener {
    private var mBinding: DialogInputItemFragmentBinding? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mBinding = DialogInputItemFragmentBinding.inflate(layoutInflater)
        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(mBinding?.root)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        initListener()
        initView()
        return dialog
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvDegree -> {
                dismiss()
            }
            R.id.tvAgree -> {
                dismiss()
                callback.invoke(mBinding?.edtInput?.text.toString())
            }
        }
    }

    fun initView() {
        mBinding?.apply {
            llButton.isVisible = name.isNullOrEmpty()
            tvTitle.text = context?.getString(R.string.item_select_label)
            if (!name.isNullOrEmpty()) {
                edtInput.setText(name, TextView.BufferType.EDITABLE)
            }
        }

    }

    private fun initListener() {
        mBinding?.apply {
            tvAgree.setOnClickListener(this@InputItemDialog)
            tvDegree.setOnClickListener(this@InputItemDialog)
        }
    }

    companion object {
        fun newInstance(name: String? = null, callback: (String) -> Unit): InputItemDialog {
            val fragment = InputItemDialog(name, callback)
            return fragment
        }
    }
}