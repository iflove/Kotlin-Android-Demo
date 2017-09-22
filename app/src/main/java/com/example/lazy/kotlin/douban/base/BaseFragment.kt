package com.example.lazy.kotlin.douban.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.module.interfaces.BaseViewInterface
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx


/**
 * Created by lazy on 2017/7/13.
 */

abstract class BaseFragment : Fragment(), BaseViewInterface {

    protected var mRootView: View? = null

    protected abstract val layoutId: Int @LayoutRes get


    final override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                    savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            val ankoComponent = ankoComponent<BaseFragment>()
            if (ankoComponent == null) {
                mRootView = inflater?.inflate(layoutId, container, false)
            } else {
                mRootView = ankoComponent.createView(AnkoContext.create(ctx, this))
            }
            if (mRootView?.id == View.NO_ID) {
                mRootView?.id = R.id.containerViewId
            }
            setupViews()
            setViewListener()

            val parent = mRootView?.parent
            if (parent != null && parent is ViewGroup) {
                parent.removeView(mRootView)
            }
        }
        this.onCreateView(mRootView!!, container, savedInstanceState)
        return mRootView
    }

    open fun onCreateView(rootView: View, container: ViewGroup?, savedInstanceState: Bundle?): Unit {

    }

    override fun initiatedLayoutView() {
        setupViews()
        setViewListener()
    }

    override fun getView(): View? {
        return mRootView
    }

    internal open fun <T> ankoComponent(): AnkoComponent<T>? = null

    override fun setupViews() {}
    override fun setViewListener() {}
    override fun processExtraData() {}
    override fun activity(): Activity = this.activity
}
