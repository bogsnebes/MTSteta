package com.bogsnebes.mts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogsnebes.mts.App.Companion.retrofit
import com.bogsnebes.mts.data.categories.CategoriesDataSource
import com.bogsnebes.mts.data.dto.ActorDto
import com.bogsnebes.mts.data.dto.ListActorsDto
import com.bogsnebes.mts.data.dto.ListMoviesDto
import com.bogsnebes.mts.data.dto.MovieDto
import com.bogsnebes.mts.data.movies.MoviesDaoImpl
import com.bogsnebes.mts.data.remote.MoviesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val moviesApi = retrofit.create(MoviesApi::class.java)

    private val moviesData = MoviesDaoImpl()
    private val categoriesData = CategoriesDataSource()

    val resultMovies = MutableLiveData<List<MovieDto>>()
    val resultCategory = MutableLiveData<List<String>>()
    val resultActors = MutableLiveData<List<ActorDto>>()
    val listMovies = mutableListOf<MovieDto>()

    fun getMovies() {
        moviesApi.getPopularMovies(1).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.deleteAllMovies()
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(2).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(3).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(4).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(5).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })
        resultMovies.value = moviesData.getFilmsOfDb()
    }

    fun getMoviesOnline() {
        moviesApi.getPopularMovies(1).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.deleteAllMovies()
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(2).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(3).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(4).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })

        moviesApi.getPopularMovies(5).enqueue(object : Callback<ListMoviesDto> {
            override fun onResponse(call: Call<ListMoviesDto>, response: Response<ListMoviesDto>) {
                val moviesList = response.body()

                if (response.code() == 200 && moviesList != null) {
                    moviesData.saveFilmsToDb(moviesList.results)
                }
            }

            override fun onFailure(call: Call<ListMoviesDto>, t: Throwable) {
            }
        })
        resultMovies.value = moviesData.getFilmsOfDb()
    }

    fun getCategories() {
        resultCategory.value = categoriesData.getCategories()
    }

    fun getProfileCategories() {
        resultCategory.value = categoriesData.getProfileCategories()
    }

    fun getActors(id: Int) {
        moviesApi.getActors(id).enqueue(object : Callback<ListActorsDto> {
            override fun onResponse(call: Call<ListActorsDto>, response: Response<ListActorsDto>) {
                val actorsList = response.body()

                if (response.code() == 200 && actorsList != null) {
                    resultActors.value = actorsList.cast
                }
            }

            override fun onFailure(call: Call<ListActorsDto>, t: Throwable) {
            }
        })
    }
}