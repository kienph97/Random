package com.example.random

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.random.databinding.LayoutItemSelectBinding
import javax.sql.StatementEvent

class SelectItemAdapter: RecyclerView.Adapter<SelectItemAdapter.SelectViewHolder>() {
    private var mList = arrayListOf<String>()

    fun setList(list: ArrayList<String>) {
        mList.clear()
        mList.addAll(list)
    }
    inner class SelectViewHolder(private var binding: LayoutItemSelectBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: String) {
            binding.tvContent.text = item
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectItemAdapter.SelectViewHolder {
        val v = LayoutItemSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectViewHolder(v)
    }

    override fun onBindViewHolder(holder: SelectItemAdapter.SelectViewHolder, position: Int) {
        mList.getOrNull(position)?.let { holder.bindData(it) }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}