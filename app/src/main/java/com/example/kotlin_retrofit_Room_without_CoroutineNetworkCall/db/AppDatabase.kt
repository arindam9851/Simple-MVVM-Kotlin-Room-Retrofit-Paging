package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem

@Database(entities = arrayOf(ResponseItem::class), version = 1, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao() : AppDao
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataseClient(context: Context) : AppDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, AppDatabase::class.java, "APP_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }
}
