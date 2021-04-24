package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.repository.MainRepository
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.BaseActivity

class DetailViewModel(private val mainRepository: MainRepository, val mContext: BaseActivity) : ViewModel() {

    fun getParticularData(id: Int): LiveData<List<ResponseItem>> {
        return mainRepository.getParticularData(id)
    }
    fun updateData(title: String, body: String,id: Int) {
        mainRepository.updateData(title,body,id)
    }

    fun deleteData(id: Int) {
        return mainRepository.deleteData(id)
    }

}