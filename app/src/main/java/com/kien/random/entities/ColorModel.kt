package com.kien.random.entities

import android.content.Context
import com.kien.random.R

data class ColorModel(
    val color: Int? = null,
    val code: String? = null
) {
    fun getListColor(context: Context) = arrayListOf(
        com.kien.random.entities.ColorModel(context.getColor(R.color.red), "#F44336"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.red1), "#D136F4"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.red2), "#F3217C"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.red4), "#FB0B03"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.yellow), "#FFEB3B"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.yellow1), "#E8D10A"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.yellow2), "#F1815E"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.yellow3), "#AF9F4C"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.green), "#4CAF50"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.green1), "#0DAC14"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.green2), "#3652A852"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.green3), "#60F106"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.blue), "#2196F3"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.blue1), "#054E88"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.blue2), "#3B6CFF"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.blue3), "#22FFD3"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.pink), "#E91E63"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.purple_200), "#BB86FC"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.purple_700), "#3700B3"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.purple_500), "#6200EE"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.black), "#000000"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.white), "#FFFFFF"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.gray), "#36414243"),
        com.kien.random.entities.ColorModel(context.getColor(R.color.colorADDCF1), "#ADDCF1")
    )
}
