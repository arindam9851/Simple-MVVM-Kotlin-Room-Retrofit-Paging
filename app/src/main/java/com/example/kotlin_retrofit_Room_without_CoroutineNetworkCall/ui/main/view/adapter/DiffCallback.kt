package com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.ui.main.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.kotlin_retrofit_Room_without_CoroutineNetworkCall.data.model.ResponseItem

class DiffCallback : DiffUtil.ItemCallback<ResponseItem>() {
    override fun areItemsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
        return oldItem == newItem
    }

}