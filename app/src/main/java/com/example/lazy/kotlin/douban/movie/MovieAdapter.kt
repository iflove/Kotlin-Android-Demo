package com.example.lazy.kotlin.douban.movie

import android.content.Context
import android.util.AndroidRuntimeException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.domain.MovieResourcesProperties
import com.example.lazy.kotlin.douban.main.WebUrlActivity
import com.example.lazy.kotlin.module.utils.ResUtil
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

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
        val ad = when (position) {
            0 -> Triple("豆瓣电影日历2018 - 豆瓣", "https://img3.doubanio.com/img/files/file-1505871396-0.jpg", "https://market.douban.com/campaign/calendar2018?r=8&index=1&category=index")
            1 -> Triple("豆瓣收藏夹 - 豆瓣", "https://img3.doubanio.com/img/files/file-1504231276-0.jpg", "https://market.douban.com/campaign/collection?r=8&index=2&category=index")
            2 -> Triple("豆瓣帆布包·早餐系列 - 豆瓣", "https://img3.doubanio.com/img/files/file-1504231219-0.jpg", "https://market.douban.com/campaign/canvasbag?r=8&index=3&category=index")
            else -> throw AndroidRuntimeException()
        }
        Glide.with(holder.itemView.context).load(ad.second)
                .centerCrop()
                .into(holder.advertisementImageView)
        holder.advertisementTitleTextView.text = ad.first
        holder.advertisemenView.setOnClickListener {
            context.startActivity<WebUrlActivity>(Pair(WebUrlActivity.EXTRA_URL, ad.third))
        }
    }

    override fun getItemCount(): Int = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_frodo_rexxar, parent, false)
        return MovieViewHolder(itemView)
    }

}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val listItemNameTextView = itemView.find<AppCompatTextView>(R.id.listItemNameTextView)
    val contentRecyclerView = itemView.find<RecyclerView>(R.id.contentRecyclerView)
    val advertisementImageView = itemView.find<AppCompatImageView>(R.id.advertisementImageView)
    val advertisementTitleTextView = itemView.find<AppCompatTextView>(R.id.advertisementTitleTextView)
    val advertisemenView = itemView.find<View>(R.id.advertisemenView)
}


