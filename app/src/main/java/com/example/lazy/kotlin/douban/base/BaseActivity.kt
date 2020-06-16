package com.example.lazy.kotlin.douban.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.example.lazy.kotlin.module.interfaces.BaseViewInterface
import com.lazy.kotlin.helper.utils.ActivityManager
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by lazy on 2017/7/13.
 */
abstract class BaseActivity : RxAppCompatActivity(), BaseViewInterface {

    val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityManager.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityManager.removeActivity(this)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initiatedLayoutView()
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
        initiatedLayoutView()
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        super.setContentView(view, params)
        initiatedLayoutView()
    }

    override fun onNewIntent(intent: Intent?) {
        setIntent(intent)
        super.onNewIntent(intent)
    }

    override fun initiatedLayoutView() {
        setupViews()
        setViewListener()
    }

    override fun setupViews() {}
    override fun setViewListener() {}
    override fun processExtraData() {}
    override fun activity(): Activity = this
}