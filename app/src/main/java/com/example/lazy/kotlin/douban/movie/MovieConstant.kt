package com.example.lazy.kotlin.douban.movie

import androidx.annotation.Nullable
import com.example.lazy.kotlin.douban.base.BasePresenter
import com.example.lazy.kotlin.douban.base.LoadDataView
import com.example.lazy.kotlin.douban.domain.MovieResourcesProperties
import com.example.lazy.kotlin.module.annotation.Optional

/**
 * Created by lazy on 2017/7/13.
 */
interface MovieConstant {

    interface MovieView : LoadDataView {
        fun onLoadMovieComplete(it: MovieResourcesProperties)
        fun onLoadAllMovieComplete()
    }

    interface MoviePresenter : BasePresenter {

        fun fetchMovieInTheaters(@Optional @Nullable city: String)
    }
}