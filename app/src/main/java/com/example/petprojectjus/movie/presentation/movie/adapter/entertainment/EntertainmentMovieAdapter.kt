package com.example.petprojectjus.movie.presentation.movie.adapter.entertainment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.EntertainmentItemBinding
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.example.petprojectjus.movie.presentation.movie.GetMovieDvo
import com.example.petprojectjus.movie.presentation.movie.adapter.MovieDiffCallback
import com.example.petprojectjus.movie.presentation.movie.adapter.OnMovieClickListener
import com.squareup.picasso.Picasso

class EntertainmentMovieAdapter :
    ListAdapter<GetMovieDvo, EntertainmentMovieViewHolder>(MovieDiffCallback) {

    var onMovieClickListener: OnMovieClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntertainmentMovieViewHolder {
        return EntertainmentMovieViewHolder(
            EntertainmentItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EntertainmentMovieViewHolder, position: Int) {
        val movie = getItem(position)

        with(holder.binding) {
            movieTitle.text = movie.title
            movieRelease.text = movie.releaseDate
            vote.text = movie.voteCount.toString()
            ratingBar.rating = (movie.voteAverage / 2).toFloat()
            Picasso.get().load(IMAGE_URL + movie.posterPath).into(movieImage)

            root.setOnClickListener {
                onMovieClickListener?.onMovieClicked(movie)

            }
        }
    }
}