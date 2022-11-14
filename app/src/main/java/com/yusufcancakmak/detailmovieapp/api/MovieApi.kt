package com.yusufcancakmak.detailmovieapp.api

import com.yusufcancakmak.detailmovieapp.helpers.Contants
import com.yusufcancakmak.detailmovieapp.model.MovieDetail
import com.yusufcancakmak.detailmovieapp.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(Contants.ENTER_POİNT)
    suspend fun getMovieApi():Response<MovieList>

    @GET("movie/{movie_id}?api_key=953ad7a70b283777e209cfea201d4a96")
    suspend fun getMovieDetailApi(@Path("movie_id")movie_id:Int):Response<List<MovieDetail>>
}