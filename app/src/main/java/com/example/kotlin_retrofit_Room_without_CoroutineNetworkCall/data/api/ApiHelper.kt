package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.PostAPIResponse
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.BaseActivity
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity
import retrofit2.HttpException
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription


class ApiHelper(private val apiService: ApiService, val mContext: BaseActivity) {
    private var postAPIResponseLiveData = MutableLiveData<PostAPIResponse>()
    private val compositeSubscription = CompositeSubscription()
    fun getPost(): MutableLiveData<PostAPIResponse> {

        compositeSubscription.add(apiService.getPost()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { postResult ->
                    postAPIResponseLiveData.postValue(postResult)
                },
                { error ->
                    Log.d("error", error.message.toString())
                    try {
                        Toast.makeText(
                            mContext,
                            (error as HttpException).message(),
                            Toast.LENGTH_LONG
                        ).show()
                    } catch (e: Exception) {
                        Log.d("error", e.message.toString())
                    }
                })
        )
        return postAPIResponseLiveData

    }

}