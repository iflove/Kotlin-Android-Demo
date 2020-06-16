package com.example.lazy.kotlin.douban.base

import androidx.annotation.StringRes
import com.example.lazy.kotlin.module.extension.toast

/**
 * Created by lazy on 2017/7/22.
 */

interface BaseView {
    fun showMessage(msg: String) {
        toast(msg)
    }

    fun showMessage(@StringRes resId: Int) {
        toast(resId)
    }

    fun showLoading()

    fun hideLoading()
}

interface LoadDataView : BaseView {

    fun onLoadDataPrepare()

    fun onLoadDataFailure()

    fun onReLoadData()

    // Just DO: 2017/2/17 DO SOMETHING
}

interface ModelDialogView : BaseView {

    fun showModelDialog()

    fun dismissModelDialog()

    // Just DO: 2017/3/15 DO SOMETHING
}


interface BasePresenter {

    /**
     * 订阅
     */
    fun subscribe()

    fun unSubscribe()
}
