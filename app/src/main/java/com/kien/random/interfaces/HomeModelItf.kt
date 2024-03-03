package com.kien.random.interfaces

import android.content.Context
import com.kien.random.entities.HomeModel

interface HomeModelItf {
    fun getListItem(context: Context): ArrayList<HomeModel>
}