package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api

import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.LanguageResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface ApiService {
    @GET("api/language/get_list")
    fun getLanguageList(@Query("appname")s: String):  Observable<LanguageResponse>



}