package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.R
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.BaseActivity
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.activity.MainActivity

class AllPostPagedAdapter(val mContext: BaseActivity) :
    PagedListAdapter<ResponseItem, AllPostPagedAdapter.ViewHolder>(DiffCallback()) {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById(R.id.txt_header) as AppCompatTextView
        val tvBody = itemView.findViewById(R.id.txt_content) as AppCompatTextView
        val tvId = itemView.findViewById(R.id.txt_id) as AppCompatTextView
        val lin = itemView.findViewById(R.id.lin) as LinearLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.row_inflate_post, parent, false)
        return ViewHolder(listItem)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var model = getItem(position)
        holder.tvTitle.text = model!!.title
        holder.tvBody.text = model.body
        holder.lin.setOnClickListener(View.OnClickListener {
            ((mContext as MainActivity).navigateData(model.id))
        })
    }
}