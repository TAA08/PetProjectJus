package com.example.petprojectjus.tvshows.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.petprojectjus.tvshows.presentation.GetTVDvo

object TVDiffCallback : DiffUtil.ItemCallback<GetTVDvo>() {
    override fun areItemsTheSame(oldItem: GetTVDvo, newItem: GetTVDvo): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GetTVDvo, newItem: GetTVDvo): Boolean {
        return oldItem == newItem
    }
}