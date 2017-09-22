package com.lazy.dagger2.di.rules

import android.app.Application
import android.content.Context

/**
 * Created by lazy on 2017/7/10.
 */
interface ApplicationRule {

    val application: Application get

    val context: Context get

}