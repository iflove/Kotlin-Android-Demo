package com.example.lazy.kotlin.douban.movie

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.domain.MovieResourcesProperties
import com.example.lazy.kotlin.module.utils.ResUtil
import org.jetbrains.anko.find

/**
 * Created by lazy on 2017/7/18.
 */
class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    lateinit var context: Context

    val movies: Array<String> = ResUtil.getStringArray(R.array.movie_list)

    val movieResourcesProperties: MutableList<MovieResourcesProperties> = mutableListOf()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.listItemNameTextView.text = movies[position]
        holder.contentRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        if (position < movieResourcesProperties.size) {
            holder.contentRecyclerView.adapter = MovieChildrenAdapter(movieResourcesProperties[position])
        }
    }

    override fun getItemCount(): Int = movies.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder {
        context = parent?.context!!
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_frodo_rexxar, parent, false)
        return MovieViewHolder(itemView)
    }

}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val listItemNameTextView = itemView.find<AppCompatTextView>(R.id.listItemNameTextView)
    val contentRecyclerView = itemView.find<RecyclerView>(R.id.contentRecyclerView)
}


