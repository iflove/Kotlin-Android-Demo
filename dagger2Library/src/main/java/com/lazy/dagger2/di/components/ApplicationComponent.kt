package com.lazy.dagger2.di.components

import android.app.Activity
import com.lazy.dagger2.di.modules.ApplicationModule
import com.lazy.dagger2.di.rules.ApplicationRule
import com.lazy.dagger2.scope.ApplicationScope
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lazy on 2017/7/10.
 */

@ApplicationScope
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent : ApplicationRule {
    fun inject(s: String)
    fun inject(a: Activity)
}
