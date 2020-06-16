package com.example.lazy.kotlin.module.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by lazy on 2017/7/22.
 */
abstract class KtBaseRecyclerViewAdapter<DS, VH : BaseViewHolder> : RecyclerView.Adapter<VH>() {

    private val dataSource: List<DS> get() = ArrayList()

    abstract val itemLayoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = LayoutInflater.from(parent.context).inflate(itemLayoutId, parent, false);
        return BaseViewHolder(itemView) as VH
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindDataToViewHolder(holder as BaseViewHolder, dataSource[position])
    }

    abstract fun onBindDataToViewHolder(baseViewHolder: BaseViewHolder, source: DS)

    override fun getItemCount(): Int = dataSource.size


}