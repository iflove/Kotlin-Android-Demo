package com.example.lazy.kotlin.module.network

import androidx.annotation.Nullable
import com.example.lazy.kotlin.douban.constant.API_VERSION
import com.example.lazy.kotlin.douban.domain.MovieResourcesProperties
import com.example.lazy.kotlin.module.annotation.Optional
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by lazy on 2017/7/11.
 */
interface DouBanApiService {

    //正在上映
    @GET(API_VERSION + "/movie/in_theaters")
    fun fetchMovieInTheaters(@Optional @Nullable @Query("city") city: String): Observable<MovieResourcesProperties>

    //即将上映
    @GET(API_VERSION + "/movie/coming_soon")
    fun fetchComingSoon(
            @Optional @Nullable @Query("start") start: Int?,
            @Optional @Nullable @Query("count") count: Int?
    ): Observable<MovieResourcesProperties>

    //Top250
    @GET(API_VERSION + "/movie/top250")
    fun fetchTop250(
            @Optional @Nullable @Query("start") start: Int?,
            @Optional @Nullable @Query("count") count: Int?
    ): Observable<MovieResourcesProperties>

    //北美票房榜
    @GET(API_VERSION + "/movie/us_box")
    fun fetchUsBox(
            @Optional @Nullable @Query("start") start: String,
            @Optional @Nullable @Query("count") count: String
    ): Observable<MovieResourcesProperties>

    //TODO
    //口碑榜
    @GET(API_VERSION + "/movie/weekly")
    fun fetchWeekly(
            @Optional @Nullable @Query("start") start: String,
            @Optional @Nullable @Query("count") count: String
    ): Observable<MovieResourcesProperties>

}