package com.yusufcancakmak.detailmovieapp.module

import com.yusufcancakmak.detailmovieapp.api.MovieApi
import com.yusufcancakmak.detailmovieapp.helpers.Contants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
     fun BASEURL()=Contants.BASE_URL


    @Provides
    @Singleton
    fun getRetrofitInstance()=
        Retrofit.Builder()
            .baseUrl(Contants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
}