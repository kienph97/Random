package com.kien.random.presenter.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kien.random.entities.HomeModel
import com.kien.random.interfaces.HomeModelItf
import com.kien.random.repositorys.HomeRepoImpl
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


class HomeViewModel @Inject constructor(): ViewModel() {
    fun getListItem(@ActivityContext context: Context, repo: HomeModelItf): ArrayList<HomeModel> = repo.getListItem(context)
}