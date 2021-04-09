package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "LanguageDB")
data class Data(
    @ColumnInfo(name = "code")
    @SerializedName("code")
    var code: String = "",
    @ColumnInfo(name = "key")
    @SerializedName("key")
    var key: String = "",
    @ColumnInfo(name = "lang")
    @SerializedName("lang")
    var lang: String = ""
)
{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null

}