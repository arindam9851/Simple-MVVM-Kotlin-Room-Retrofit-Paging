package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.Data
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.LanguageResponse
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.repository.MainRepository
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity

class MainActivityViewModel(private val mainRepository: MainRepository,  val mContext: MainActivity) : ViewModel() {
    fun networkcall(appname: String): MutableLiveData<LanguageResponse> {
        return mainRepository.languageList(appname)
    }
    fun insertData(data: Data) {
        mainRepository.insertData(data)
    }
    fun getLanguage(): LiveData<List<Data>> {
        return mainRepository.getLanguageData()
    }

}