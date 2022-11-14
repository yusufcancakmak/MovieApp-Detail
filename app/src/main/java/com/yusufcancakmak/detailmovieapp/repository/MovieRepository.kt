package com.yusufcancakmak.detailmovieapp.repository

import android.util.Log
import com.yusufcancakmak.detailmovieapp.api.MovieApi
import com.yusufcancakmak.detailmovieapp.model.MovieList
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val api:MovieApi) {

    suspend fun getMovieRepository():Response<MovieList>{
        val response =api.getMovieApi()
        if (response.isSuccessful){
            Log.d("testApp","Response api success connected")
            Log.d("testApp",response.code().toString())
        }else
        {
            Log.d("testApp","Response api failed connected")
            Log.d("testApp",response.code().toString())

        }
        return response
    }
}