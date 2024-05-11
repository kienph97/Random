package com.kien.random.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.kien.random.databinding.LayoutItemHomeBinding
import javax.inject.Inject

class HomeAdapter @Inject constructor(): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var mListData = arrayListOf<HomeModel>()
    private var mTypeDisplay = LIST
    var mCallBackClickItem: ((Int) -> Unit)? = null

    fun setData(list: ArrayList<HomeModel>) {
        mListData.clear()
        mListData.addAll(list)
        notifyDataSetChanged()
    }

    fun setTypeDisplay(type: String) {
        mTypeDisplay = type
    }

    fun getTypeDisplay() = mTypeDisplay

    fun setCallBackClickItem(callback: (Int) -> Unit) {
        mCallBackClickItem = callback
    }

    inner class HomeViewHolder(private val itemHomeBinding: LayoutItemHomeBinding): RecyclerView.ViewHolder(itemHomeBinding.root) {
        fun bindData(item: HomeModel) {
            when (mTypeDisplay) {
                GRILL -> {
                    itemHomeBinding.apply {
                        ctlList.isVisible = false
                        ctlGrill.isVisible = true
                        imvIconGrill.setImageResource(item.icon)
                        tvTitleGrill.text = item.title
                        root.apply {
                            setOnClickListener {
                                mCallBackClickItem?.invoke(item.id)
                            }
                        }
                    }
                }
                LIST -> {
                    itemHomeBinding.apply {
                        ctlList.isVisible = true
                        ctlGrill.isVisible = false
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

    companion object {
        const val GRILL = "GRILL"
        const val LIST = "LIST"
    }
}