package com.android.developer.testapp.presentation.adapter.recycler.renderer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.developer.testapp.R
import com.android.developer.testapp.common.Constants
import com.android.developer.testapp.domain.entity.MappingResponse
import com.android.developer.testapp.presentation.adapter.recycler.holder.ImageViewHolder
import com.bumptech.glide.Glide

class ImageRenderer : ViewRenderer<MappingResponse.Image, ImageViewHolder>() {

    private lateinit var context: Context

    override fun createViewHolder(parent: ViewGroup): ImageViewHolder {
        context = parent.context
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
    }

    override fun bindView(model: MappingResponse.Image, holder: ImageViewHolder, position: Int) {
        val urlAuthor = "${Constants.BASE_URL}${model.authorAvatar}"
        Glide.with(context).load(urlAuthor).into(holder.ivAvatar)
        holder.tvName.text = model.authorName
        holder.tvTitle.text = model.title
        holder.tvImageTitle1.text = model.imageTitle1
        holder.tvImageTitle2.text = model.imageTitle2
        holder.tvImageTitle3.text = model.imageTitle3

        val url1 = "${Constants.BASE_URL}${model.imageUrl1}"
        val url2 = "${Constants.BASE_URL}${model.imageUrl2}"
        val url3 = "${Constants.BASE_URL}${model.imageUrl3}"
        Glide.with(context).load(url1).into(holder.image1)
        Glide.with(context).load(url2).into(holder.image2)
        Glide.with(context).load(url3).into(holder.image3)
    }
}