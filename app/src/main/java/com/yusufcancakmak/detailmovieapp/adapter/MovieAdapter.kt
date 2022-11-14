package com.yusufcancakmak.detailmovieapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.unit.Constraints
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusufcancakmak.detailmovieapp.MovieDetailActivity
import com.yusufcancakmak.detailmovieapp.databinding.ItemMoviesBinding
import com.yusufcancakmak.detailmovieapp.helpers.Contants
import com.yusufcancakmak.detailmovieapp.model.Movie
import com.yusufcancakmak.detailmovieapp.model.MovieDetail

class MovieAdapter():RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private val differutil=object :DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return newItem.id==oldItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem==newItem
        }

    }

    private val differ= AsyncListDiffer(this,differutil)
    var movielist:List<Movie>
        get() = differ.currentList
        set(value){
            differ.submitList(value)
        }
    inner class ViewHolder(val binding: ItemMoviesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentlist=movielist[position]
        holder.binding.tvMovieName.text=currentlist.originalTitle.toString()
        holder.binding.tvLang.text=currentlist.originalLanguage.toString()
        holder.binding.tvRate.text=currentlist.voteAverage.toString()
        Glide.with(holder.itemView).load(Contants.PHOTO_URL+currentlist.posterPath).into(holder.binding.imgMovie)
        holder.binding.tvMovieDateRelease.text=currentlist.releaseDate.toString()

        holder.binding.dataRoot.setOnClickListener {
            val intent=Intent(holder.itemView.context,MovieDetailActivity::class.java)
            intent.putExtra("movie_id",currentlist.id)
            intent.putExtra("originalTitle",currentlist.originalTitle)
            intent.putExtra("poster_path",currentlist.posterPath)
            intent.putExtra("backdrop",currentlist.backdropPath)
            intent.putExtra("vote",currentlist.voteAverage)
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount()=movielist.size
}