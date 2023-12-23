package com.example.random.presenter.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.random.entities.ColorModel
import com.example.random.R
import java.util.Random

open class BaseViewModel: ViewModel() {
    private var yesOrNoLiveData = MutableLiveData<String>()
    private var rpsLiveData = MutableLiveData<Int>()
    private var colorLiveData = MutableLiveData<Int>()
    private var coinLiveData = MutableLiveData<Int>()
    private var chooseItemLiveData = MutableLiveData<Int>()
    private var diceRandomLiveData = MutableLiveData<ArrayList<Int>>()
    fun getRandomNumber(start: Int, end: Int): Int {
        val random = Random()
        return random.nextInt(end - start + 1) + start
    }

    fun getRandomItem(start: Int, end: Int) {
        chooseItemLiveData.value = getRandomNumber(start, end)
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

    fun getRandomDice(number: Int) {
        val list = ArrayList<Int>();
        for (i in 0 until number) {
            list.add(getRandomNumber(1,6))
        }
        diceRandomLiveData.value = list
    }
    fun getYesOrNoLiveData() = yesOrNoLiveData

    fun getRPSLiveData() = rpsLiveData

    fun getColorLiveData() = colorLiveData

    fun getCoinLiveData() = coinLiveData

    fun getChooseItemLiveData() = chooseItemLiveData

    fun getDiceRandomLiveData() = diceRandomLiveData
}