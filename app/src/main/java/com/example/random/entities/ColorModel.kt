package com.example.random.entities

import android.content.Context
import com.example.random.R

data class ColorModel(
    val color: Int? = null,
    val code: String? = null
) {
    fun getListColor(context: Context) = arrayListOf(
        ColorModel(context.getColor(R.color.red), "#F44336"),
        ColorModel(context.getColor(R.color.red1), "#D136F4"),
        ColorModel(context.getColor(R.color.red2), "#F3217C"),
        ColorModel(context.getColor(R.color.red4), "#FB0B03"),
        ColorModel(context.getColor(R.color.yellow), "#FFEB3B"),
        ColorModel(context.getColor(R.color.yellow1), "#E8D10A"),
        ColorModel(context.getColor(R.color.yellow2), "#F1815E"),
        ColorModel(context.getColor(R.color.yellow3), "#AF9F4C"),
        ColorModel(context.getColor(R.color.green), "#4CAF50"),
        ColorModel(context.getColor(R.color.green1), "#0DAC14"),
        ColorModel(context.getColor(R.color.green2), "#3652A852"),
        ColorModel(context.getColor(R.color.green3), "#60F106"),
        ColorModel(context.getColor(R.color.blue), "#2196F3"),
        ColorModel(context.getColor(R.color.blue1), "#054E88"),
        ColorModel(context.getColor(R.color.blue2), "#3B6CFF"),
        ColorModel(context.getColor(R.color.blue3), "#22FFD3"),
        ColorModel(context.getColor(R.color.pink), "#E91E63"),
        ColorModel(context.getColor(R.color.purple_200), "#BB86FC"),
        ColorModel(context.getColor(R.color.purple_700), "#3700B3"),
        ColorModel(context.getColor(R.color.purple_500), "#6200EE"),
        ColorModel(context.getColor(R.color.black), "#000000"),
        ColorModel(context.getColor(R.color.white), "#FFFFFF"),
        ColorModel(context.getColor(R.color.gray), "#36414243"),
        ColorModel(context.getColor(R.color.colorADDCF1), "#ADDCF1")
    )
}
