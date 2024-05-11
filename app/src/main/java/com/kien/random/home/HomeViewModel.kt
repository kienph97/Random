package com.kien.random.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kien.random.home.HomeModel
import com.kien.random.home.HomeModelItf
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


class HomeViewModel @Inject constructor(): ViewModel() {
    fun getListItem(@ActivityContext context: Context, repo: HomeModelItf): ArrayList<HomeModel> = repo.getListItem(context)
}