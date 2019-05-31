package com.android.developer.testapp.presentation.adapter.recycler.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.android.developer.testapp.R

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ivAvatar: ImageView = itemView.findViewById(R.id.iv_author_avatar)
    val tvName: TextView = itemView.findViewById(R.id.tv_author_name)
    val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    val tvImageTitle1: TextView = itemView.findViewById(R.id.tv_image_title1)
    val tvImageTitle2: TextView = itemView.findViewById(R.id.tv_image_title2)
    val tvImageTitle3: TextView = itemView.findViewById(R.id.tv_image_title3)
    val image1: ImageView = itemView.findViewById(R.id.iv1)
    val image2: ImageView = itemView.findViewById(R.id.iv2)
    val image3: ImageView = itemView.findViewById(R.id.iv3)
}