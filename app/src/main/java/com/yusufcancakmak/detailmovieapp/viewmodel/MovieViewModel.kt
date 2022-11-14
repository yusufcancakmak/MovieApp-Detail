package com.yusufcancakmak.detailmovieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufcancakmak.detailmovieapp.model.Movie
import com.yusufcancakmak.detailmovieapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movierepo:MovieRepository):ViewModel() {

    private val _getMovieMutableLiveData=MutableLiveData<List<Movie>>()
    val getmovielivedata:LiveData<List<Movie>> = _getMovieMutableLiveData

    fun getMovieviewmodel(){
        viewModelScope.launch {
            val response=movierepo.getMovieRepository()
            if (response.isSuccessful){
                response.body()!!.results.let {
                    _getMovieMutableLiveData.postValue(it)
                }
            }
        }
    }
}