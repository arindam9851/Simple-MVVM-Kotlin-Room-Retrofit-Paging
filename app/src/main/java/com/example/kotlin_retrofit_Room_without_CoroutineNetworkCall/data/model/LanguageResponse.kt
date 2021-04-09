package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model


import com.google.gson.annotations.SerializedName

data class LanguageResponse(
    @SerializedName("data")
    var `data`: List<Data> = listOf(),
    @SerializedName("success")
    var success: Boolean = false,
    @SerializedName("totalCount")
    var totalCount: Int = 0
)