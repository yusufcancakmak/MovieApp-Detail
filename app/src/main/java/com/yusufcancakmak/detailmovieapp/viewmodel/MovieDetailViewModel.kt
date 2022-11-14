package com.yusufcancakmak.detailmovieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufcancakmak.detailmovieapp.model.MovieDetail
import com.yusufcancakmak.detailmovieapp.repository.MovieDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val movidetailrepo:MovieDetailRepository):ViewModel()  {

    private val _getmoviedetailmuablelist = MutableLiveData<List<MovieDetail>>()

    val getmoviedetailLivedata : LiveData<List<MovieDetail>> = _getmoviedetailmuablelist

    fun moviedetailviewmodel(movie_id:Int){
       viewModelScope.launch {
           val response=movidetailrepo.getMovieDetailRepo(movie_id)
          if (response.isSuccessful){
              _getmoviedetailmuablelist.postValue(listOf(response.body()!![0]))
          }
       }

    }
}


