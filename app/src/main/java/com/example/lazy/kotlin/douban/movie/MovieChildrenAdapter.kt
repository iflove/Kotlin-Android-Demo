package com.example.lazy.kotlin.douban.movie

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import com.bumptech.glide.Glide
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.domain.MovieResourcesProperties
import org.jetbrains.anko.find

/**
 * Created by lazy on 2017/7/18.
 */
class MovieChildrenAdapter(val movieResourcesProperties: MovieResourcesProperties) : RecyclerView.Adapter<MovieChildrenViewHolder>() {


    override fun getItemCount(): Int = movieResourcesProperties.count

    override fun onBindViewHolder(holder: MovieChildrenViewHolder, position: Int) {
        val subjects = movieResourcesProperties.subjects[position]
        holder.nameTextView.text = subjects.title
        val bit = subjects.rating.max / holder.ratingBar.numStars

        holder.ratingBar.rating = subjects.rating.average / bit
        Glide.with(holder.itemView.context).load(subjects.images.medium).into(holder.movieImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieChildrenViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_in_theaters_movie, parent, false)
        return MovieChildrenViewHolder(view)
    }


}

class MovieChildrenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val movieImageView = itemView.find<AppCompatImageView>(R.id.movieImageView)
    val nameTextView = itemView.find<AppCompatTextView>(R.id.nameTextView)
    val ratingBar = itemView.find<RatingBar>(R.id.ratingBar)
}


