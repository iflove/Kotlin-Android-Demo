package com.example.lazy.kotlin.module.base

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.find

/**
 * Created by lazy on 2017/7/22.
 */
open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setImageResource(@IdRes id: Int, @DrawableRes drawableResId: Int): BaseViewHolder {
        itemView.find<ImageView>(id).setImageResource(drawableResId)
        return this
    }

    fun setBackgroundResource(@IdRes id: Int, @DrawableRes drawableResId: Int): BaseViewHolder {
        itemView.find<ImageView>(id).setBackgroundResource(drawableResId)
        return this
    }
}