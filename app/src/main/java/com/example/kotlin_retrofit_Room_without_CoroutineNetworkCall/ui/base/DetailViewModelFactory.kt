package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.ApiHelper
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.repository.MainRepository
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.BaseActivity
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel.DetailViewModel

class DetailViewModelFactory (private val apiHelper: ApiHelper, val mContext: BaseActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(MainRepository(apiHelper,mContext),mContext) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}