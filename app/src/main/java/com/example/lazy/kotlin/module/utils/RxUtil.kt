package com.example.lazy.kotlin.module.utils

import androidx.annotation.NonNull
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by lazy on 2017/7/22.
 */
object RxUtil {

    fun <T> toHttpResultObservable(@NonNull src: Observable<T>): Observable<T> {
        return src.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

    }
}
