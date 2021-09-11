package com.bogsnebes.mts.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bogsnebes.mts.App
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.data.movies.MoviesDao

@Database(entities = [MovieDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

    companion object {
        private const val DATABASE_NAME = "Movies.db"

        val instance: AppDatabase by lazy {
            Room.databaseBuilder(
                App.context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}