package com.example.petprojectjus.celebrity.presentation.celebrity.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityDvo

object CelebrityDiffCallback : DiffUtil.ItemCallback<CelebrityDvo>() {
    override fun areItemsTheSame(oldItem: CelebrityDvo, newItem: CelebrityDvo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CelebrityDvo, newItem: CelebrityDvo): Boolean {
        return oldItem == newItem
    }
}