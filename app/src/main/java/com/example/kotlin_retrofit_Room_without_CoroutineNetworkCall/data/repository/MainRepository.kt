package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.ApiHelper
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.Data
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.LanguageResponse
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.db.AppDatabase
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainRepository(private val apiHelper: ApiHelper, val mContext: MainActivity)  {
    var appDatabase: AppDatabase? = null
    fun languageList(appname: String): MutableLiveData<LanguageResponse>  {
        return apiHelper.languageList(appname)
    }

    fun initializeDB(context: Context) : AppDatabase {
        return AppDatabase.getDataseClient(context)
    }

    fun insertData(data: Data) {

        appDatabase = initializeDB(mContext)

        CoroutineScope(Dispatchers.IO).launch {
            appDatabase!!.appDao().insertAll(data)
        }

    }
    fun getLanguageData(): LiveData<List<Data>> {
        appDatabase = initializeDB(mContext)
        return appDatabase!!.appDao().getPosts()
    }



}