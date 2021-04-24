package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "allPostTable")
data class ResponseItem(
        @ColumnInfo(name = "body")
        @SerializedName("body")
        var body: String = "",
        @PrimaryKey
        @SerializedName("id")
        var id: Int = 0,
        @ColumnInfo(name = "title")
        @SerializedName("title")
        var title: String = "",
        @ColumnInfo(name = "userId")
        @SerializedName("userId")
        var userId: Int = 0
)