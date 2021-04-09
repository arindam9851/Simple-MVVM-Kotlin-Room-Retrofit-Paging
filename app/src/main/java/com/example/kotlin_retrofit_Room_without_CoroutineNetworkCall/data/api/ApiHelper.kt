package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.AppUtils
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.LanguageResponse
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity
import retrofit2.HttpException
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiHelper(private val apiService: ApiService, val mContext: MainActivity){
    var postAPIResponseLiveData = MutableLiveData<LanguageResponse>()
    fun languageList(appname: String): MutableLiveData<LanguageResponse> {
        apiService.getLanguageList(appname)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                AppUtils.getInstance().showProgressDialog(mContext)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { postResult ->
                    AppUtils.getInstance().hideProgressDialog(mContext)
                    postAPIResponseLiveData.postValue(postResult)
                },
                { error ->
                    AppUtils.getInstance().hideProgressDialog(mContext)
                    Log.d("error",error.message.toString())
                    Toast.makeText(mContext,(error as HttpException).message(),Toast.LENGTH_LONG).show()
                }
            )
        return postAPIResponseLiveData
    }

}