package com.kien.random.home

import android.content.Context
import com.kien.random.home.HomeModel

interface HomeModelItf {
    fun getListItem(context: Context): ArrayList<HomeModel>
}