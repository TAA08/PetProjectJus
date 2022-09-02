package com.example.petprojectjus.tvshows.presentation.adapter.toprated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.TopRatedMovieItemBinding
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.example.petprojectjus.tvshows.presentation.GetTVDvo
import com.example.petprojectjus.tvshows.presentation.adapter.OnTVClickListener
import com.example.petprojectjus.tvshows.presentation.adapter.TVDiffCallback
import com.squareup.picasso.Picasso

class TopRatedTVAdapter : ListAdapter<GetTVDvo, TopRatedTVViewHolder>(TVDiffCallback) {

    private var onTvClickListener: OnTVClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedTVViewHolder {
        return TopRatedTVViewHolder(
            TopRatedMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedTVViewHolder, position: Int) {
        val tv = getItem(position)

        with(holder.binding) {
            movieTitle.text = tv.name
            movieRelease.text = tv.firstAirDate
            Picasso.get().load(IMAGE_URL + tv.posterPath).into(movieImage)

            root.setOnClickListener {
                onTvClickListener?.onTVClicked(tv)

            }
        }
    }
}