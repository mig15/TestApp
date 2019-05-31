package com.android.developer.testapp.presentation.adapter.recycler

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.android.developer.testapp.presentation.adapter.recycler.renderer.ViewRenderer

class RecyclerAdapter(private val data: MutableList<ItemType> = arrayListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val rendererArray = ArrayList<ViewRenderer<ItemType, RecyclerView.ViewHolder>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return rendererArray[viewType].createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        rendererArray[item.getType()].bindView(item, holder, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getType()
    }

    fun <M : ItemType, VH : RecyclerView.ViewHolder> registerRenderer(renderer: ViewRenderer<M, VH>) {
        renderer as ViewRenderer<ItemType, RecyclerView.ViewHolder>
        rendererArray.add(renderer)
    }

    fun notifyData(list: List<ItemType>) {
        data.addAll(list)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int) = data[position]
}