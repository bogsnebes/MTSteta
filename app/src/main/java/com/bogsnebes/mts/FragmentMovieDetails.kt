package com.bogsnebes.mts

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bogsnebes.mts.data.dto.MovieDto

class FragmentMovieDetails : Fragment(R.layout.fragment_movie_details) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (arguments?.getSerializable("MOVIE") as? MovieDto)?.let { movieDto ->
        TODO()
        }

        val x = arguments?.getSerializable("MOVIE")
    }


    companion object {
        val TAG: String = FragmentMovieDetails::class.java.simpleName
        fun newInstance(movieDto: MovieDto) = FragmentMovieDetails().apply {
            arguments = bundleOf("MOVIE" to movieDto)
        }
    }
}