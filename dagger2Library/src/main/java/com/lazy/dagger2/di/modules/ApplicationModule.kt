package com.lazy.dagger2.di.modules

import android.app.Application
import android.content.Context
import com.lazy.dagger2.di.rules.ApplicationRule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lazy on 2017/7/10.
 */
@Module
class ApplicationModule(val _application: Application) : ApplicationRule {

    override val application: Application
        @Provides
        @Singleton
        get() = _application


    override val context: Context
        @Provides
        @Singleton
        get() = _application.applicationContext

}