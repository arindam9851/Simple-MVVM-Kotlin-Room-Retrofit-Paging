package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.ApiHelper
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.repository.MainRepository
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel.MainActivityViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, val mContext: MainActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(MainRepository(apiHelper,mContext),mContext) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}