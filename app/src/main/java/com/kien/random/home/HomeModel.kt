package com.kien.random.home


import com.kien.random.R
import com.kien.random.common.models.BaseModel

data class HomeModel(
    override val id: Int = 1,
    val icon: Int = R.drawable.ic_lucky_number,
    val title: String = ""
) : BaseModel() {
}
