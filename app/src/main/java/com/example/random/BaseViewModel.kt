package com.example.random

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Random

open class BaseViewModel: ViewModel() {
    private var yesOrNoLiveData = MutableLiveData<String>()
    private var rpsLiveData = MutableLiveData<Int>()
    private var colorLiveData = MutableLiveData<Int>()
    private var coinLiveData = MutableLiveData<Int>()
    fun getRandomNumber(start: Int, end: Int): Int {
        val random = Random()
        return random.nextInt(end - start + 1) + start
    }

    fun getRandomCoin() {
        coinLiveData.value = getRandomNumber(0, 1)
    }

    fun getYesOrNo(context: Context) {
        when (getRandomNumber(0, 1)) {
            0 -> {
                yesOrNoLiveData.value = context.getString(R.string.yes_label)
            }
            1 -> {
                yesOrNoLiveData.value = context.getString(R.string.no_label)
            }
        }

    }

    fun getRandomColor(context: Context) {
        val index = getRandomNumber(0, 11)
        val list = ColorModel().getListColor(context)
        colorLiveData.value = list.getOrNull(index)
    }

    fun getRandomRPS() {
        rpsLiveData.value = getRandomNumber(0, 2)
    }
    fun getYesOrNoLiveData() = yesOrNoLiveData

    fun getRPSLiveData() = rpsLiveData

    fun getColorLiveData() = colorLiveData

    fun getCoinLiveData() = coinLiveData
}