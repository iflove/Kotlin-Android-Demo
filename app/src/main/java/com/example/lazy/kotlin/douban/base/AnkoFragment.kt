package com.example.lazy.kotlin.douban.base

import org.jetbrains.anko.AnkoComponent

/**
 * Created by lazy on 2017/7/30.
 */
abstract class AnkoFragment : BaseFragment() {

    override val layoutId: Int
        get() = 0

    override final fun <T> ankoComponent(): AnkoComponent<T>?
            = onCreateAnkoComponent()

    abstract fun <T> onCreateAnkoComponent(): AnkoComponent<T>

}