package com.kien.random.modules.color.interfaces

import android.content.Context
import com.kien.random.modules.color.ColorModel

interface ColorModelItf {
    fun getListColor(context: Context): ArrayList<ColorModel>
}