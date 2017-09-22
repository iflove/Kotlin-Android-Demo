package com.example.lazy.kotlin.douban.base

import com.example.lazy.kotlin.douban.application.MyApplication
import com.example.lazy.kotlin.module.network.DouBanApiService

/**
 * Created by lazy on 2017/7/22.
 */
open class BaseDouBanPresenter(val douBanApiService: DouBanApiService = MyApplication.mRetrofitModule.douBanApiService()) : BasePresenter {

    override fun subscribe() {

    }

    override fun unSubscribe() {
    }
}