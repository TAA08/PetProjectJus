package com.example.petprojectjus.presentation.movie.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.petprojectjus.presentation.movie.GetMovieDvo

object TopRatedMovieDiffCallback : DiffUtil.ItemCallback<GetMovieDvo>() {
    override fun areItemsTheSame(oldItem: GetMovieDvo, newItem: GetMovieDvo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GetMovieDvo, newItem: GetMovieDvo): Boolean {
        return  oldItem == newItem
    }
}