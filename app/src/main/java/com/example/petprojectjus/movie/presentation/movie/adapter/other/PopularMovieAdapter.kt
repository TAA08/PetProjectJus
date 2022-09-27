package com.example.petprojectjus.movie.presentation.movie.adapter.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.PopularMovieItemBinding
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.example.petprojectjus.movie.presentation.movie.GetMovieDvo
import com.example.petprojectjus.movie.presentation.movie.adapter.MovieDiffCallback
import com.example.petprojectjus.movie.presentation.movie.adapter.OnMovieClickListener
import com.squareup.picasso.Picasso

open class PopularMovieAdapter :
    ListAdapter<GetMovieDvo, PopularMovieViewHolder>(MovieDiffCallback) {

    var onMovieClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        return PopularMovieViewHolder(
            PopularMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
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