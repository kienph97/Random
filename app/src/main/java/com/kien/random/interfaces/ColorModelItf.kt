package com.kien.random.interfaces

import android.content.Context
import com.kien.random.entities.ColorModel

interface ColorModelItf {
    fun getListColor(context: Context): ArrayList<ColorModel>
}