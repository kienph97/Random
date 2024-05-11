package com.kien.random.modules.luckynumber.viewmodels

import androidx.lifecycle.MutableLiveData
import com.kien.random.common.viewmodels.BaseViewModel
import javax.inject.Inject

class LuckyNumberViewModel @Inject constructor(): BaseViewModel() {
    private var luckyNumberLiveData = MutableLiveData<Int>()
    fun getLuckyNumber(start: Int, end: Int) {
        luckyNumberLiveData.value = getRandomNumber(start, end)
    }

    fun getLuckyNumberLiveData() = luckyNumberLiveData
}