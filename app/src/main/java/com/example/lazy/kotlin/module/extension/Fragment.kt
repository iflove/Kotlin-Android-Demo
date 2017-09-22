package com.example.lazy.kotlin.module.extension

import android.support.v4.app.Fragment

/**
 * Created by lazy on 2017/7/31.
 */

val Fragment.receiverTransaction get() = this.fragmentManager.beginTransaction()
