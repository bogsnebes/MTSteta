package com.bogsnebes.mts.data.remote

import com.bogsnebes.mts.data.dto.ListActorsDto
import com.bogsnebes.mts.data.dto.ListMoviesDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular?api_key=73706453e495f004b0ac2611a019fc95&language=ru-RU")
    fun getPopularMovies(@Query("page") page: Int): Call<ListMoviesDto>

    @GET("movie/{movie_id}/credits?api_key=73706453e495f004b0ac2611a019fc95&language=ru-RU")
    fun getActors(@Path("movie_id") movie_id: Int): Call<ListActorsDto>
}