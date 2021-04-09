package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.Data

@Dao
interface AppDao {
    @Insert
    fun insertAll( data: Data)

    @Query("SELECT * FROM LanguageDB")
    fun getPosts(): LiveData<List<Data>>
}