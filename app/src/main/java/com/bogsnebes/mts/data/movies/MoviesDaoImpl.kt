package com.bogsnebes.mts.data.movies

import com.bogsnebes.mts.data.AppDatabase
import com.bogsnebes.mts.data.dto.MovieDto

class MoviesDaoImpl {

    fun saveFilmsToDb(list: List<MovieDto>) {
        val db = AppDatabase.instance
        db.moviesDao().insertAll(list)
    }

    fun getFilmsOfDb(): List<MovieDto> {
        val db = AppDatabase.instance
        return db.moviesDao().getMovies()
    }

    fun getLittleFilmsOfDb(): List<MovieDto> {
        val db = AppDatabase.instance
        return db.moviesDao().getMoviesLittle()
    }

    fun deleteAllMovies() {
        val db = AppDatabase.instance
        return db.moviesDao().deleteAll()
    }
}
