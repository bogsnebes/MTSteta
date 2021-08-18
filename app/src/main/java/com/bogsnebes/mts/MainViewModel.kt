package com.bogsnebes.mts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.data.categories.CategoriesDataSource
import com.bogsnebes.mts.data.movies.MoviesDaoImpl

class MainViewModel : ViewModel() {
    private val moviesData = MoviesDaoImpl()
    private val categoriesData = CategoriesDataSource()

    val resultMovies = MutableLiveData<List<MovieDto>>()
    val resultCategory = MutableLiveData<List<String>>()

    init {
        moviesData.saveFilmsToDb()
    }

    fun getMoviesLittle() {
        resultMovies.value = moviesData.getLittleFilmsOfDb()
    }

    fun getMovies() {
        resultMovies.value = moviesData.getFilmsOfDb()
    }

    fun getCategories() {
        resultCategory.value = categoriesData.getCategories()
    }

    fun getProfileCategories() {
        resultCategory.value = categoriesData.getProfileCategories()
    }
}