package com.yusufcancakmak.detailmovieapp.repository

import android.util.Log
import com.yusufcancakmak.detailmovieapp.api.MovieApi
import com.yusufcancakmak.detailmovieapp.model.MovieDetail
import retrofit2.Response
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(private val moviedetailapi:MovieApi) {

    suspend fun getMovieDetailRepo(movie_id:Int): Response<List<MovieDetail>> {
        val response=moviedetailapi.getMovieDetailApi(movie_id)
        if (response.isSuccessful){
            Log.d("testApp","Success response repositroy")
            Log.d("testApp",response.code().toString())
        }else {
            Log.d("testApp","Failed response repository")
            Log.d("testApp",response.code().toString())
        }

        return response
    }

}