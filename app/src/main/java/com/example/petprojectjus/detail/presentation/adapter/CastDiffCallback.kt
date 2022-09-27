package com.example.petprojectjus.detail.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.petprojectjus.detail.presentation.dvo.CastDvo

object CastDiffCallback: DiffUtil.ItemCallback<CastDvo>() {
    override fun areItemsTheSame(oldItem: CastDvo, newItem: CastDvo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CastDvo, newItem: CastDvo): Boolean {
        return oldItem == newItem
    }
}