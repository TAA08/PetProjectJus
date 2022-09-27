package com.example.petprojectjus.detail.presentation.adapter.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.PopularMovieItemBinding
import com.example.petprojectjus.detail.presentation.adapter.MovieDetailDiffCallback
import com.example.petprojectjus.detail.presentation.dvo.MovieDetailDvo
import com.example.petprojectjus.detail.presentation.dvo.MovieDvo
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.example.petprojectjus.movie.presentation.movie.adapter.OnMovieClickListener
import com.squareup.picasso.Picasso

open class SimilarMovieAdapter :
    ListAdapter<MovieDvo, SimilarMovieViewHolder>(MovieDetailDiffCallback) {

    var onMovieClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMovieViewHolder {
        return SimilarMovieViewHolder(
            PopularMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SimilarMovieViewHolder, position: Int) {
        val movie = getItem(position)

        with(holder.binding) {
            movieTitle.text = movie.title
            movieRelease.text = movie.releaseDate
            Picasso.get().load(IMAGE_URL + movie.posterPath).into(movieImage)

            root.setOnClickListener {
                onMovieClickListener?.onMovieClicked(movie.id)
            }
        }
    }

}