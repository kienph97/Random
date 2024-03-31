package com.kien.random.entities


import android.content.Context
import com.kien.random.R
import com.kien.random.interfaces.HomeModelItf

data class HomeModel(
    override val id: Int = 1,
    val icon: Int = R.drawable.ic_lucky_number,
    val title: String = ""
) : BaseModel() {
}
