package com.bogsnebes.mts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bogsnebes.mts.data.dto.MovieDto

open class FragmentMovieDetails: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    companion object {
        val TAG: String = FragmentMovieDetails::class.java.simpleName
        fun newInstance(movieDto: MovieDto) = FragmentMovieDetails()
    }
}