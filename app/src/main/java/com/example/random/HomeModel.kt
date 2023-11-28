package com.example.random


import android.content.Context
import androidx.core.content.ContextCompat

data class HomeModel(
    override val id: Int = 1,
    val icon: Int = R.drawable.ic_lucky_number,
    val title: String = ""
) : BaseModel() {
    fun getListItem(context: Context) = arrayListOf(
        HomeModel(id = 1, icon = R.drawable.ic_lucky_number, title = context.getString(R.string.lucky_number_label)),
        HomeModel(id = 2, icon = R.drawable.ic_yes_or_no, title = context.getString(R.string.yes_or_no_label)),
        HomeModel(id = 3, icon = R.drawable.ic_list, title = context.getString(R.string.choose_item_label)),
        HomeModel(id = 4, icon = R.drawable.ic_rps, title = context.getString(R.string.RPS_label)),
        HomeModel(id = 5, icon = R.drawable.ic_coin, title = context.getString(R.string.coin_label)),
        HomeModel(id = 6, icon = R.drawable.ic_color, title = context.getString(R.string.color_label)),
        HomeModel(id = 7, icon = R.drawable.ic_dice_roller, title = context.getString(R.string.dice_roller_label))
    )
}
