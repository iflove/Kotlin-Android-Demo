package com.example.lazy.kotlin.module.extension

import android.app.Activity
import android.view.View
import com.example.lazy.kotlin.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.setContentView

/**
 * Created by lazy on 2017/7/30.
 */

fun Activity.containerViewUI(): AnkoComponent<Activity> = object : AnkoComponent<Activity> {

    override fun createView(ui: AnkoContext<Activity>): View = ui.apply {
        frameLayout {
            id = R.id.containerViewId
        }
    }.view

}

fun <T : Activity> Activity.setContainerViewUI(activity: T): View {
    return activity.containerViewUI().setContentView(activity)
}


