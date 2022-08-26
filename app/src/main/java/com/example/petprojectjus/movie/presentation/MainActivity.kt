package com.example.petprojectjus.movie.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.petprojectjus.R
import com.example.petprojectjus.movie.presentation.movie.MovieFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MovieFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}