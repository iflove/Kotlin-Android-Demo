package com.example.lazy.kotlin.module.interfaces

import android.app.Activity

/**
 * Created by lazy on 2017/7/13.
 */
interface BaseViewInterface {

    fun initiatedLayoutView(): Unit

    fun setupViews(): Unit

    fun setViewListener(): Unit

    /**
     * 加载数据
     */
    fun processExtraData(): Unit

    fun activity(): Activity
}