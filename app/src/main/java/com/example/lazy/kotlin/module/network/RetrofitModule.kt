package com.example.lazy.kotlin.module.network

import com.example.lazy.kotlin.douban.constant.DOU_BAN_API
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by lazy on 2017/7/11.
 */
object RetrofitModule {

    val douBanApiService by lazy { retrofit().create(DouBanApiService::class.java) }

    fun defaultOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(DOU_BAN_API)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(defaultOkHttpClient())
                .build()
    }


}