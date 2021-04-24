package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem

@Dao
interface AppDao {
    @Insert
    fun insertAll( data: ResponseItem)

    @Query("SELECT * FROM allPostTable")
    fun getPost(): LiveData<List<ResponseItem>>

    @Query("SELECT * FROM allPostTable Where id=:id")
    fun getParticularData(id: Int): LiveData<List<ResponseItem>>

    @Query("UPDATE allPostTable SET title=:title,body=:body WHERE id=:id")
    fun updateData (title: String, body: String,id: Int)

    @Query("DELETE FROM allPostTable WHERE id=:id")
    fun delete (id: Int)
}
