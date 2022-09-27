package com.example.petprojectjus.detail.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.petprojectjus.detail.presentation.dvo.ResultDvo
import com.example.petprojectjus.detail.presentation.dvo.TrailerDvo

object TrailerDiffCallback : DiffUtil.ItemCallback<ResultDvo>() {
    override fun areItemsTheSame(oldItem: ResultDvo, newItem: ResultDvo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResultDvo, newItem: ResultDvo): Boolean {
        return oldItem == newItem
    }
}