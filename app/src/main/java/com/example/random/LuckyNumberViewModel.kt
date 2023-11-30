package com.example.random

import androidx.lifecycle.MutableLiveData

class LuckyNumberViewModel: BaseViewModel() {
    private var luckyNumberLiveData = MutableLiveData<Int>()
    fun getLuckyNumber(start: Int, end: Int) {
        luckyNumberLiveData.value = getRandomNumber(start, end)
    }

    fun getLuckyNumberLiveData() = luckyNumberLiveData
}