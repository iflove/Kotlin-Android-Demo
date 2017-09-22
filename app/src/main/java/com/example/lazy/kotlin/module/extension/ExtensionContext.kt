package com.example.lazy.kotlin.module.extension

import android.content.Context
import com.example.lazy.kotlin.douban.application.MyApplication

/**
 * Created by lazy on 2017/7/13.
 */

val mContext: Context = MyApplication.instance.applicationContext

inline val Any.context: Context get() = mContext
