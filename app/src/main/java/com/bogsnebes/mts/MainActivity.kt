package com.bogsnebes.mts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.data.movies.MoviesDataSourceImpl

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var recyclerMovie: RecyclerView
    private lateinit var recyclerCategory: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, FragmentListOfMovies())
            .commit()

        supportFragmentManager.setFragmentResultListener(
            FragmentListOfMovies.MOVIE_OPEN_KEY,
            this
        ) { requestCode, bundle ->
            (bundle.getSerializable(FragmentListOfMovies.MOVIE_OPEN_KEY) as? MovieDto)?.let {

                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.container, FragmentMovieDetails.newInstance(
                            it
                        )
                    )
                    .commit()
            }
        }

    }

    companion object {
        val movieData = MoviesDataSourceImpl()
    }
}