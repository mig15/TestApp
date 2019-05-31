package com.android.developer.testapp.presentation.adapter.recycler.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.android.developer.testapp.R

class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ivAvatar: ImageView = itemView.findViewById(R.id.iv_author_avatar)
    val tvName: TextView = itemView.findViewById(R.id.tv_author_name)
    val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    val tvMessage: TextView = itemView.findViewById(R.id.tv_message)
}