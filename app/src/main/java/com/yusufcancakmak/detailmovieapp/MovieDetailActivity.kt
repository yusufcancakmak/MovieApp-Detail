package com.yusufcancakmak.detailmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.yusufcancakmak.detailmovieapp.databinding.ActivityMovieDetailBinding
import com.yusufcancakmak.detailmovieapp.helpers.Contants
import com.yusufcancakmak.detailmovieapp.model.MovieDetail
import com.yusufcancakmak.detailmovieapp.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding
    private   var movie_id:Int?=null
    private lateinit var movieName:String
    private val detailmoviemvvm:MovieDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



       getInformation()




    }
    private fun getInformation(){
        val intent=intent
        binding.prgBarMovies.visibility=View.GONE
      movie_id=  intent.getIntExtra("movie_id",0)
        movieName=intent.getStringExtra("originalTitle").toString()
        val backdrop=intent.getStringExtra("poster_path").toString()
        val posterpath=intent.getStringExtra("backdrop").toString()
        val vote=intent.getDoubleExtra("vote",0.0).toString()
        binding.tvMovieTitle.text=movieName.toString()
        Glide.with(this@MovieDetailActivity).load(Contants.PHOTO_URL+backdrop).into(binding.imgMovie)
        Glide.with(this@MovieDetailActivity).load(Contants.PHOTO_URL+posterpath).into(binding.imgMovieBack)
        binding.tvMovieRating.text=vote

        detailmoviemvvm.moviedetailviewmodel(movie_id!!)
        detailmoviemvvm.getmoviedetailLivedata.observe(this, Observer { data->
            binding.tvMovieOverview.text=data[0].overview.toString()

        })


    }




}






