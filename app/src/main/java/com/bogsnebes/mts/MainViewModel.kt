package com.bogsnebes.mts

import androidx.lifecycle.ViewModel
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.data.movies.CategoriesDataSource
import com.bogsnebes.mts.data.movies.MoviesDataSourceImpl

class MainViewModel : ViewModel() {
    private val moviesData = MoviesDataSourceImpl()
    private val categoriesData = CategoriesDataSource()

    fun getMoviesLittle(): List<MovieDto> {
        return moviesData.getMoviesLittle()
    }

    fun getMovies(): List<MovieDto> {
        return moviesData.getMovies()
    }

    fun getCategories(): List<kotlin.String> {
        return categoriesData.getCategories()
    }

    fun getProfileCategories(): List<kotlin.String> {
        return categoriesData.getProfileCategories()
    }
}