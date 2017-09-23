package com.example.lazy.kotlin.douban.base

import com.example.lazy.kotlin.module.network.DouBanApiService
import com.example.lazy.kotlin.module.network.RetrofitModule
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by lazy on 2017/7/22.
 */
open class BaseDouBanPresenter(val douBanApiService: DouBanApiService = RetrofitModule.douBanApiService)
    : BasePresenter {

    val compositeDisposable = CompositeDisposable()

    override fun subscribe() {

    }

    override fun unSubscribe() {
        if (compositeDisposable.isDisposed.not()) {
            compositeDisposable.dispose()
        }
    }
}