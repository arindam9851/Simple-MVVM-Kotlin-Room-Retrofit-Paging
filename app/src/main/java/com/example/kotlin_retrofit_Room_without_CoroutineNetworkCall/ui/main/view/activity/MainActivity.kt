package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.R
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.ApiHelper
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.RetrofitBuilder
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.Data
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.base.ViewModelFactory
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setUpLanguageListObserver()
//        setUpDatbaseObserver()
    }

    private fun setUpDatbaseObserver() {
        viewModel.getLanguage() .observe(this, Observer {
            if(it!=null)
                Toast.makeText(this,it[1].lang,Toast.LENGTH_LONG).show()
            Log.d("tag",it.toString())
        })

    }

    private fun setUpLanguageListObserver() {
        viewModel.networkcall("com")
                .observe(this, Observer {
                    if(it!=null)
                    {
                        for(i in it.data.indices)
                        {
                            var data1 = Data()
                            data1.key=it.data[i].key
                            data1.lang=it.data[i].lang
                            data1.code=it.data[i].code
                            viewModel.insertData(data1)
                        }
                        Toast.makeText(this,"Insert Successful",Toast.LENGTH_LONG).show()
                        Log.d("tag",it.data.toString())
                    }
                })



    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService,this),this)
        ).get(MainActivityViewModel::class.java)

    }
}