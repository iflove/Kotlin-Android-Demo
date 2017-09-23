package com.example.lazy.kotlin.module.extension

import android.content.Context
import com.example.lazy.kotlin.douban.application.MyApplication.Companion.appContext

/**
 * Created by lazy on 2017/7/13.
 */


@PublishedApi
internal inline val Any.context: Context get() = appContext
