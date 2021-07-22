package com.bogsnebes.mts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bogsnebes.mts.data.movies.MoviesDataSourceImpl

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerMovie: RecyclerView
    private lateinit var recyclerCategory: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        recyclerMovie = findViewById(R.id.recyclerMovie)
        recyclerCategory = findViewById(R.id.recyclerCategory)

        recyclerCategory.hasFixedSize()
        val categoryes = listOf<String>("боевики", "драмы", "комедии", "артхаус", "мелодрамы")
        recyclerCategory.adapter = CategoryAdapter(categoryes, this)

        recyclerMovie.hasFixedSize()
        recyclerMovie.layoutManager = GridLayoutManager(this, 2)
        recyclerMovie.adapter = MyMoviesAdapter(movieData.getMovies(), this)


    }

    companion object {
        val movieData = MoviesDataSourceImpl()
    }
}