package com.example.lazy.kotlin.douban.movie

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.anko.component.LoadingFragment
import com.example.lazy.kotlin.douban.base.BaseFragment
import com.example.lazy.kotlin.douban.domain.MovieResourcesProperties
import com.example.lazy.kotlin.module.extension.receiverTransaction
import kotlinx.android.synthetic.main.recycler_view.*

/**
 * Created by lazy on 2017/7/13.
 */
class MovieFragment : BaseFragment(), MovieConstant.MovieView {

    override var layoutId: Int = R.layout.fragment_movie

    val moviePresenter: MoviePresenter = MoviePresenter()
    lateinit var movieAdapter: MovieAdapter


    override fun onCreateView(rootView: View, container: ViewGroup?, savedInstanceState: Bundle?) {
        super.onCreateView(rootView, container, savedInstanceState)
        moviePresenter.movieView = this
        processExtraData()
    }

    override fun setupViews() {
        super.setupViews()
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        movieAdapter = MovieAdapter()
    }

    override fun processExtraData() {
        super.processExtraData()
        showMessage("已定位广州")
        moviePresenter.fetchMovieInTheaters("广州")
    }

    override fun onLoadMovieComplete(it: MovieResourcesProperties) {
        movieAdapter.movieResourcesProperties.add(it)
    }

    override fun onLoadAllMovieComplete() {
        recyclerView.adapter = movieAdapter
//        movieAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        val loadingFragment = LoadingFragment()
        fragmentManager.beginTransaction()
                .add(R.id.containerViewId, loadingFragment, "LoadingFragment")
                .commit()

    }

    override fun hideLoading() {
        val fragment = fragmentManager.findFragmentByTag("LoadingFragment")
        with(receiverTransaction) {
            remove(fragment)
            commit()
        }
    }

    override fun onLoadDataPrepare() {
    }

    override fun onLoadDataFailure() {
    }

    override fun onReLoadData() {
    }
}