package com.example.random.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.random.databinding.LayoutItemHomeBinding
import com.example.random.entities.HomeModel

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var mListData = arrayListOf<HomeModel>()
    var mCallBackClickItem: ((Int) -> Unit)? = null

    fun setData(list: ArrayList<HomeModel>) {
        mListData.clear()
        mListData.addAll(list)
    }

    fun setCallBackClickItem(callback: (Int) -> Unit) {
        mCallBackClickItem = callback
    }

    inner class HomeViewHolder(private val itemHomeBinding: LayoutItemHomeBinding): RecyclerView.ViewHolder(itemHomeBinding.root) {
        fun bindData(item: HomeModel) {
            itemHomeBinding.apply {
                imvIcon.setImageResource(item.icon)
                tvTitle.text = item.title
                root.apply {
                    setOnClickListener {
                        mCallBackClickItem?.invoke(item.id)
                    }
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(v)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        mListData.getOrNull(position)?.let { holder.bindData(it) }
    }

    override fun getItemCount() = mListData.size
}