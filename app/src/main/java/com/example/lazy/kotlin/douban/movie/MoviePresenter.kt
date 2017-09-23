package com.example.lazy.kotlin.douban.movie

import android.util.Log
import com.example.lazy.kotlin.douban.base.BaseDouBanPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by lazy on 2017/7/22.
 */
class MoviePresenter : BaseDouBanPresenter(), MovieConstant.MoviePresenter {

    lateinit var movieView: MovieConstant.MovieView


    override fun fetchMovieInTheaters(city: String) {
        val movieInTheaters = douBanApiService.fetchMovieInTheaters(city)
        val comingSoon = douBanApiService.fetchComingSoon(null, null)
        val top250 = douBanApiService.fetchTop250(null, null)
        val disposable = Observable.mergeArray(movieInTheaters, comingSoon, top250)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    movieView.showLoading()
                }
                .subscribe({
                    movieView.onLoadMovieComplete(it)
                }, {
                    Log.d("xxa", it.cause.toString())
                }, {
                    movieView.hideLoading()
                    movieView.onLoadAllMovieComplete()
                })
        compositeDisposable.add(disposable)
    }


}