package com.yusufcancakmak.detailmovieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusufcancakmak.detailmovieapp.adapter.MovieAdapter
import com.yusufcancakmak.detailmovieapp.databinding.FragmentMoviesBinding
import com.yusufcancakmak.detailmovieapp.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var movieAdapter: MovieAdapter
    private val movieviewmodel:MovieViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter=MovieAdapter()
        setuprv()


    }
    private fun setuprv() {
        binding.moviesRv.apply {
            adapter=movieAdapter
            layoutManager=LinearLayoutManager(this.context)

            }
        movieviewmodel.getMovieviewmodel()
        movieviewmodel.getmovielivedata.observe(viewLifecycleOwner){response->
            movieAdapter.movielist=response


        }
    }

}