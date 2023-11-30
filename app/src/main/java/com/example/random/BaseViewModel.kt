package com.example.random

import androidx.lifecycle.ViewModel
import java.util.Random

open class BaseViewModel: ViewModel() {
    fun getRandomNumber(start: Int, end: Int): Int {
        val random = Random()
        return random.nextInt(end - start + 1) + start
    }
}