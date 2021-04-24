package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.R
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.ApiHelper
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.RetrofitBuilder
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.PostAPIResponse
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.base.ViewModelFactory
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.adapter.AllPostAdapter
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var mAdapter: AllPostAdapter
    private var mList = ArrayList<ResponseItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUI()
        setupViewModel()
        setUpDatabaseObserver()


    }

    private fun setUpDatabaseObserver() {
        viewModel.getAllPost()
                .observe(this, Observer {
                    if(it.isNotEmpty()){
                        mList.clear()
                        mList.addAll(it)
                        mAdapter.notifyDataSetChanged()
                    }
                    else{
                        setUpApiCallObserver()
                    }
                })

    }

    private fun setUpUI() {

        mAdapter = AllPostAdapter(mList, this)
        recycler_post.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)
            adapter = mAdapter
        }
    }


    private fun setUpApiCallObserver() {
        viewModel.getPost()
                .observe(this, Observer {
                    if(it.isNotEmpty())
                    {
                        insertDataToDb(it)

                    }
                })



    }

    private fun insertDataToDb(postAPIResponse: PostAPIResponse) {
        for(i in postAPIResponse.indices){
            var model=ResponseItem()
            model.body=postAPIResponse[i].body
            model.id=postAPIResponse[i].id
            model.title=postAPIResponse[i].title
            model.userId=postAPIResponse[i].userId
            viewModel.insertData(model)

        }

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService,this),this)
        ).get(MainActivityViewModel::class.java)

    }

    fun navigateData(id: Int) {

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
    }
}