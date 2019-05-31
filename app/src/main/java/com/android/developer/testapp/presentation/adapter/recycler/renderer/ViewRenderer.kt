package com.android.developer.testapp.presentation.adapter.recycler.renderer

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.android.developer.testapp.presentation.adapter.recycler.ItemType

abstract class ViewRenderer<M : ItemType, VH : RecyclerView.ViewHolder> {

    abstract fun createViewHolder(parent: ViewGroup): VH

    abstract fun bindView(model: M, holder: VH, position: Int)
}