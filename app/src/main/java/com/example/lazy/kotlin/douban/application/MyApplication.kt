package com.example.lazy.kotlin.douban.application

import android.support.multidex.MultiDexApplication
import com.example.lazy.kotlin.module.network.RetrofitModule
import com.example.lazy.kotlin.module.utils.ResUtil
import com.lazy.library.logging.Logcat


/**
 * Created by lazy on 2017/7/7.
 */
class MyApplication : MultiDexApplication() {

    companion object {

        lateinit var instance: MyApplication

        lateinit var mRetrofitModule: RetrofitModule
    }

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    fun initialize() {
        instance = this
        mRetrofitModule = RetrofitModule()

        Logcat.initialize(this)
        ResUtil.inject(this)
    }

}