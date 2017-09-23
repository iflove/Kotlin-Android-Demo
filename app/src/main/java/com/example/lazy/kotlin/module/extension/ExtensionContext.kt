package com.example.lazy.kotlin.module.extension

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.lazy.kotlin.douban.application.MyApplication.Companion.appContext

/**
 * Created by lazy on 2017/7/13.
 */


inline val Any.context: Context get() = appContext

@PublishedApi
inline internal fun SharedPreferences.applyMe(func: SharedPreferences.Editor.() -> SharedPreferences.Editor) {
    this.edit().func().apply()
}

@SuppressLint("ApplySharedPref")
@PublishedApi
inline internal fun SharedPreferences.commitMe(func: SharedPreferences.Editor.() -> SharedPreferences.Editor) {
    this.edit().func().commit()
}