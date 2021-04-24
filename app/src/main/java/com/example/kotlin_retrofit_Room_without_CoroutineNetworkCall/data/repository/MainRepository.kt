package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.ApiHelper
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.PostAPIResponse
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.db.AppDatabase
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.BaseActivity
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainRepository(private val apiHelper: ApiHelper, val mContext: BaseActivity)  {
    var appDatabase: AppDatabase? = null
    fun getPost(): MutableLiveData<PostAPIResponse>  {
        return apiHelper.getPost()
    }

    fun initializeDB(context: Context) : AppDatabase {
        return AppDatabase.getDataseClient(context)
    }

    fun insertData(data: ResponseItem) {

        appDatabase = initializeDB(mContext)

        CoroutineScope(Dispatchers.IO).launch {
            appDatabase!!.appDao().insertAll(data)
        }

    }
    fun getAllPost(): LiveData<List<ResponseItem>> {
        appDatabase = initializeDB(mContext)
        return appDatabase!!.appDao().getPost()
    }

    fun getParticularData(id: Int): LiveData<List<ResponseItem>> {
        appDatabase = initializeDB(mContext)
        return appDatabase!!.appDao().getParticularData(id)
    }

    fun updateData(title: String, body: String,id: Int) {
        appDatabase = initializeDB(mContext)
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase!!.appDao().updateData(title,body,id)
        }


    }

    fun deleteData(id: Int) {
        appDatabase = initializeDB(mContext)
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase!!.appDao().delete(id)
        }


    }



}