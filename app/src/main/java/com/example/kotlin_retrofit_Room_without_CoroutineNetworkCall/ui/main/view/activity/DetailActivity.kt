package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.R
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.ApiHelper
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.api.RetrofitBuilder
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.base.DetailViewModelFactory
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(), View.OnClickListener {
    private var id: Int = 0
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (intent.hasExtra("id"))
            id = intent.getIntExtra("id", 0)
        setupViewModel()
        setUpUI()
        if (id != 0)
            fetchDataObserver()
    }

    private fun fetchDataObserver() {
        viewModel.getParticularData(id)
            .observe(this, Observer {
                if (it.isNotEmpty()) {
                    setData(it[0].title, it[0].body)
                }
            })

    }

    private fun setData(title: String, body: String) {
        et_note_header.setText(title)
        et_note.setText(body)
    }

    private fun setUpUI() {
        img_update.setOnClickListener(this)
        img_delete_data.setOnClickListener(this)

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            DetailViewModelFactory(ApiHelper(RetrofitBuilder.apiService, this), this)
        ).get(DetailViewModel::class.java)

    }

    override fun onClick(v: View?) {
        val id = v!!.id
        when (id) {
            R.id.img_update -> {
                viewModel.updateData(
                    et_note_header.text.toString(),
                    et_note.text.toString(),
                    this.id
                )
                finish()
            }

            R.id.img_delete_data -> {
                viewModel.deleteData(this.id)
                finish()
            }
        }
    }
}