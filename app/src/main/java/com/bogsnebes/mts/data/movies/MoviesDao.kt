package com.bogsnebes.mts.data.movies

import androidx.room.*
import com.bogsnebes.mts.data.dto.MovieDto

@Dao
interface MoviesDao {

    @Query("SELECT * FROM films")
    fun getMovies(): List<MovieDto>

    @Query("SELECT * FROM films LIMIT 3")
    fun getMoviesLittle(): List<MovieDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(film: List<MovieDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(film: MovieDto)

    @Update
    fun update(film: MovieDto)

//    Delete from database

    @Delete
    fun delete(film: MovieDto)

    @Query("DELETE FROM films WHERE id = :filmId")
    fun deleteById(filmId: Long)

    @Query("DELETE FROM films")
    fun deleteAll()
}