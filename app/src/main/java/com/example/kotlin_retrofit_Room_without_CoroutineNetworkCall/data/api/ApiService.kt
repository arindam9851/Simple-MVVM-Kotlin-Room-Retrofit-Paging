package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api

import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.PostAPIResponse
import retrofit2.http.GET
import rx.Observable

interface ApiService {
    @GET("posts")
    fun getPost():  Observable<PostAPIResponse>



}