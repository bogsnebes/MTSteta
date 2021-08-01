package com.bogsnebes.mts

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.data.movies.MoviesDataSourceImpl
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(R.layout.activity_main),
    BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var bottomNavigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bottomNavigationMenu = findViewById(R.id.bottomNavigationView)

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

        bottomNavigationMenu.setOnNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentListOfMovies()).commit()
            R.id.profile -> return false
        }
        return true
    }

    companion object {
        val movieData = MoviesDataSourceImpl()
    }
}
