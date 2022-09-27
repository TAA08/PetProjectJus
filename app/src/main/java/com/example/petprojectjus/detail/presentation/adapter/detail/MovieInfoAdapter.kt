package com.example.petprojectjus.detail.presentation.adapter.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.MovieInformationItemBinding
import com.example.petprojectjus.detail.presentation.adapter.MovieDetailDiffCallback
import com.example.petprojectjus.detail.presentation.adapter.TrailerDiffCallback
import com.example.petprojectjus.detail.presentation.dvo.MovieDetailDvo
import com.example.petprojectjus.detail.presentation.dvo.ResultDvo

class MovieInfoAdapter : ListAdapter<ResultDvo, MovieInfoViewHolder>(TrailerDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieInfoViewHolder {
        return MovieInfoViewHolder(
            MovieInformationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieInfoViewHolder, position: Int) {
        val trailerDetail = getItem(position)
        with(holder.binding){

        }
    }
}