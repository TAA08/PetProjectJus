package com.example.petprojectjus.presentation.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.TopRatedMovieItemBinding
import com.example.petprojectjus.presentation.IMAGE_URL
import com.example.petprojectjus.presentation.movie.GetMovieDvo
import com.squareup.picasso.Picasso

class TopRatedMovieAdapter :
    ListAdapter<GetMovieDvo, TopRatedMovieViewHolder>(TopRatedMovieDiffCallback) {

    var onMovieClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieViewHolder {
        return TopRatedMovieViewHolder(
            TopRatedMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        val movie = getItem(position)

        with(holder.binding) {
            movieTitle.text = movie.title
            movieRelease.text = movie.releaseDate
            Picasso.get().load(IMAGE_URL + movie.posterPath).into(movieImage)

            root.setOnClickListener {
                onMovieClickListener?.onMovieClick(movie)

            }
        }
    }
}