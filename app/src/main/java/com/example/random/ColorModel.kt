package com.example.random

import android.content.Context

data class ColorModel(
    val color: Int? = null
) {
    fun getListColor(context: Context) = arrayListOf(
        context.getColor(R.color.red),
        context.getColor(R.color.yellow),
        context.getColor(R.color.green),
        context.getColor(R.color.blue),
        context.getColor(R.color.pink),
        context.getColor(R.color.purple_200),
        context.getColor(R.color.purple_700),
        context.getColor(R.color.purple_500),
        context.getColor(R.color.black),
        context.getColor(R.color.white),
        context.getColor(R.color.gray),
        context.getColor(R.color.colorADDCF1)
    )
}
