package com.example.lazy.kotlin.douban.movie

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.domain.MovieResourcesProperties
import com.example.lazy.kotlin.module.utils.ResUtil
import org.jetbrains.anko.find

/**
 * Created by lazy on 2017/7/18.
 */
class MovieChildrenAdapter(val movieResourcesProperties: MovieResourcesProperties) : RecyclerView.Adapter<MovieChildrenViewHolder>() {


    override fun getItemCount(): Int = movieResourcesProperties.count

    override fun onBindViewHolder(holder: MovieChildrenViewHolder, position: Int) {
        val subjects = movieResourcesProperties.subjects[position]
        holder.nameTextView.text = subjects.title
        val average = subjects.rating.average
        if (average > 0.0f) {
            val bit = subjects.rating.max / holder.ratingBar.numStars
            holder.ratingBar.rating = average / bit
            holder.ratingTextView.text = average.toString()
        } else {
            holder.ratingBar.visibility = View.GONE
            holder.ratingTextView.text = ResUtil.getString(R.string.text_no_score)
        }

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
    val ratingTextView = itemView.find<TextView>(R.id.ratingTextView)
}


