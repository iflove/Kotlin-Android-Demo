package com.example.lazy.kotlin.module.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * Created by lazy on 2017/7/31.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commitAllowingStateLoss()
}
//inline fun FragmentManager?.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
//    this?.beginTransaction()?.func()?.commitAllowingStateLoss()
//}

inline fun Fragment.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    this.fragmentManager!!.inTransaction(func)
}

inline fun Fragment.inChildTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    this.childFragmentManager.inTransaction(func)
}

inline fun FragmentActivity.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    this.supportFragmentManager.inTransaction(func)
}

