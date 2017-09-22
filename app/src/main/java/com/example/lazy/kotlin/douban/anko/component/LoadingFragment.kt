package com.example.lazy.kotlin.douban.anko.component

import android.view.Gravity
import android.widget.LinearLayout
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.base.AnkoFragment
import org.jetbrains.anko.*

/**
 * Created by lazy on 2017/7/30.
 */

class LoadingFragment : AnkoFragment() {

    override fun <T> onCreateAnkoComponent(): AnkoComponent<T> {
        return LoadingFragmentUI<T>()
    }

}


class LoadingFragmentUI<T> : AnkoComponent<T> {
    override fun createView(ui: AnkoContext<T>) = with(ui) {
        verticalLayout {
            gravity = Gravity.CENTER

            progressBar { }

            textView(R.string.text_loading) {
                layoutParams = LinearLayout.LayoutParams(wrapContent, wrapContent).apply {
                    topMargin = dip(15)
                }

            }

        }
    }

}