package com.example.lazy.kotlin.douban.movie

import com.example.lazy.kotlin.douban.base.BaseDouBanPresenter
import com.lazy.library.logging.Logcat
import com.trello.rxlifecycle2.android.FragmentEvent
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
                .compose((movieView as MovieFragment).bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    movieView.showLoading()
                }
                .subscribe({
                    movieView.onLoadMovieComplete(it)
                }, {
                    Logcat.d("xxa", it.cause.toString())
                }, {
                    movieView.hideLoading()
                    movieView.onLoadAllMovieComplete()
                })
        compositeDisposable.add(disposable)
    }


}
