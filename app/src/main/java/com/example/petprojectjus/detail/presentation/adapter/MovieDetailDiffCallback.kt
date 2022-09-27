package com.example.petprojectjus.detail.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.petprojectjus.detail.presentation.dvo.MovieDvo

object MovieDetailDiffCallback: DiffUtil.ItemCallback<MovieDvo>() {
    override fun areItemsTheSame(oldItem: MovieDvo, newItem: MovieDvo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieDvo, newItem: MovieDvo): Boolean {
        return oldItem == newItem
    }
}