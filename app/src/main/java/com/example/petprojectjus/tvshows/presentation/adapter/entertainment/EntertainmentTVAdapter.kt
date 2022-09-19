package com.example.petprojectjus.tvshows.presentation.adapter.entertainment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.EntertainmentItemBinding
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.example.petprojectjus.tvshows.presentation.GetTVDvo
import com.example.petprojectjus.tvshows.presentation.adapter.OnTVClickListener
import com.example.petprojectjus.tvshows.presentation.adapter.TVDiffCallback
import com.squareup.picasso.Picasso

class EntertainmentTVAdapter :
    ListAdapter<GetTVDvo, EntertainmentTVViewHolder>(TVDiffCallback) {

    private var onTvClickListener: OnTVClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntertainmentTVViewHolder {
        return EntertainmentTVViewHolder(
            EntertainmentItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EntertainmentTVViewHolder, position: Int) {
        val tv = getItem(position)

        with(holder.binding) {
            movieTitle.text = tv.name
            movieRelease.text = tv.firstAirDate
            vote.text = tv.voteCount.toString()
            ratingBar.rating = (tv.voteAverage / 2).toFloat()
            Picasso.get().load(IMAGE_URL + tv.posterPath).into(movieImage)

            root.setOnClickListener {
                onTvClickListener?.onTVClicked(tv)

            }
        }
    }
}