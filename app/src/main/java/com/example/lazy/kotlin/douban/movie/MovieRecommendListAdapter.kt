package com.example.lazy.kotlin.douban.movie

import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.module.base.BaseViewHolder
import com.example.lazy.kotlin.module.base.KtBaseRecyclerViewAdapter

/**
 * Created by lazy on 2017/7/27.
 */
class MovieRecommendListAdapter : KtBaseRecyclerViewAdapter<Int, BaseViewHolder>() {


    override val itemLayoutId: Int = R.layout.item_frodo_rexxar

    override fun onBindDataToViewHolder(baseViewHolder: BaseViewHolder, source: Int) {
        baseViewHolder.setImageResource(R.id.movieRecommendImageView, source)
    }
}