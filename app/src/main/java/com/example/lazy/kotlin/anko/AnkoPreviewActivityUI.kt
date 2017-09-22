package com.example.lazy.kotlin.anko

import com.example.lazy.kotlin.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout

/**
 * Created by lazy on 2017/7/30.
 */
class AnkoPreviewActivityUI : AnkoComponent<AnkoPreviewActivity> {

    override fun createView(ui: AnkoContext<AnkoPreviewActivity>) = ui.apply {
        frameLayout {
            id = R.id.contentView
        }
    }.view

}