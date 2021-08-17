package com.bogsnebes.mts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.data.movies.CategoriesDataSource
import com.bogsnebes.mts.data.movies.MoviesDataSourceImpl

class MainViewModel : ViewModel() {
    private val moviesData = MoviesDataSourceImpl()
    private val categoriesData = CategoriesDataSource()

    val resultMovies = MutableLiveData<List<MovieDto>>()
    val resultCategory = MutableLiveData<List<String>>()

    fun getMoviesLittle() {
        resultMovies.value = moviesData.getMoviesLittle()
    }

    fun getMovies() {
        resultMovies.value = moviesData.getMovies()
    }

    fun getCategories() {
        resultCategory.value = categoriesData.getCategories()
    }

    fun getProfileCategories() {
        resultCategory.value = categoriesData.getProfileCategories()
    }
}