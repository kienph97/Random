package com.kien.random.presenter.viewmodels

import androidx.lifecycle.MutableLiveData
import com.kien.random.presenter.viewmodels.BaseViewModel

class LuckyNumberViewModel: BaseViewModel() {
    private var luckyNumberLiveData = MutableLiveData<Int>()
    fun getLuckyNumber(start: Int, end: Int) {
        luckyNumberLiveData.value = getRandomNumber(start, end)
    }

    fun getLuckyNumberLiveData() = luckyNumberLiveData
}