package com.bogsnebes.mts.data.movies

import com.bogsnebes.mts.data.dto.MovieDto

interface MoviesDataSource {
    fun getMovies(): List<MovieDto>
}