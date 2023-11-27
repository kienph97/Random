package com.example.random


import android.content.Context
import androidx.core.content.ContextCompat

data class HomeModel(
    val icon: Int = R.drawable.ic_lucky_number,
    val title: String = ""
) : BaseModel() {
    fun getListItem(context: Context) = arrayListOf(
        HomeModel(icon = R.drawable.ic_lucky_number, title = context.getString(R.string.lucky_number_label)),
        HomeModel(icon = R.drawable.ic_yes_or_no, title = context.getString(R.string.yes_or_no_label)),
        HomeModel(icon = R.drawable.ic_list, title = context.getString(R.string.choose_item_label)),
    )
}
