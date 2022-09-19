package com.example.petprojectjus.celebrity.presentation.celebrity.adapter.entertainment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.petprojectjus.celebrity.presentation.celebrity.CelebrityDvo
import com.example.petprojectjus.celebrity.presentation.celebrity.adapter.CelebrityDiffCallback
import com.example.petprojectjus.celebrity.presentation.celebrity.adapter.OnCelebrityClickListener
import com.example.petprojectjus.databinding.EntertainmentSelebrityItemBinding
import com.example.petprojectjus.movie.presentation.IMAGE_URL
import com.squareup.picasso.Picasso

class EntertainmentCelebrityAdapter :
    ListAdapter<CelebrityDvo, EntertainmentCelebrityViewHolder>(CelebrityDiffCallback) {

    var onCelebrityClickListener: OnCelebrityClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntertainmentCelebrityViewHolder {
        return EntertainmentCelebrityViewHolder(
            EntertainmentSelebrityItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EntertainmentCelebrityViewHolder, position: Int) {
        val celebrity = getItem(position)

        with(holder.binding){
            celebrityName.text = celebrity.name
            celebrityWork.text = celebrity.known_for_department
            Picasso.get().load(IMAGE_URL + celebrity.profile_path).into(celebrityImage)

            root.setOnClickListener {
                onCelebrityClickListener?.onCelebrityClicked(celebrity)
            }
        }
    }
}