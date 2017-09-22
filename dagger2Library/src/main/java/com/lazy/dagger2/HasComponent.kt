package com.lazy.dagger2

/**
 * Created by lazy on 2017/7/10.
 */
interface HasComponent<C> {
    fun component(): C
}