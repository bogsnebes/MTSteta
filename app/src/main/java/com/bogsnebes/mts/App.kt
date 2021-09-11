package com.bogsnebes.mts

import android.app.Application
import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {
    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    override fun onCreate() {
        super.onCreate()
        application = this

        retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {
        var application: Application? = null
            private set
        val context: Context
            get() = application!!.applicationContext

        lateinit var retrofit: Retrofit
    }
}