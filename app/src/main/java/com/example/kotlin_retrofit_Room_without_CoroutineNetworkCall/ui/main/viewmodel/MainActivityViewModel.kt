package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.PostAPIResponse
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.repository.MainRepository
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.BaseActivity
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity

class MainActivityViewModel(private val mainRepository: MainRepository,  val mContext: BaseActivity) : ViewModel() {

    fun getPost(): MutableLiveData<PostAPIResponse> {
        return mainRepository.getPost()
    }

    fun insertData(data: ResponseItem) {
        mainRepository.insertData(data)
    }

    fun getAllPost(): LiveData<List<ResponseItem>> {
        return mainRepository.getAllPost()
    }
}