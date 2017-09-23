package com.example.lazy.kotlin.module.extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by lazy on 2017/7/31.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commitAllowingStateLoss()
}

inline fun Fragment.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    this.fragmentManager.inTransaction(func)
}

inline fun Fragment.inChildTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    this.childFragmentManager.inTransaction(func)
}

inline fun FragmentActivity.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    this.supportFragmentManager.inTransaction(func)
}

