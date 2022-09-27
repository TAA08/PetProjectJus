package com.example.petprojectjus.detail.presentation.adapter.cast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.databinding.PopularCelebrityItemBinding
import com.example.petprojectjus.detail.presentation.adapter.CastDiffCallback
import com.example.petprojectjus.detail.presentation.dvo.CastDvo
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.squareup.picasso.Picasso

class MovieCastAdapter : ListAdapter<CastDvo, MovieCastViewHolder>(CastDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCastViewHolder {
        return MovieCastViewHolder(
            PopularCelebrityItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieCastViewHolder, position: Int) {
        val cast = getItem(position)

        with(holder.binding){
            celebrityName.text = cast.name
            celebrityWork.text = cast.knownForDepartment
            Picasso.get().load(IMAGE_URL + cast.profilePath).into(celebrityImage)
        }
    }
}