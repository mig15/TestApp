package com.android.developer.testapp.presentation.adapter.recycler.renderer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.developer.testapp.R
import com.android.developer.testapp.common.Constants
import com.android.developer.testapp.domain.entity.MappingResponse
import com.android.developer.testapp.presentation.adapter.recycler.holder.TextViewHolder
import com.bumptech.glide.Glide

class TextRenderer : ViewRenderer<MappingResponse.Text, TextViewHolder>() {

    private lateinit var context: Context

    override fun createViewHolder(parent: ViewGroup): TextViewHolder {
        context = parent.context
        return TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false))
    }

    override fun bindView(model: MappingResponse.Text, holder: TextViewHolder, position: Int) {
        val url = "${Constants.BASE_URL}${model.authorAvatar}"
        Glide.with(context).load(url).into(holder.ivAvatar)
        holder.tvName.text = model.authorName
        holder.tvTitle.text = model.title
        holder.tvMessage.text = model.message
    }
}