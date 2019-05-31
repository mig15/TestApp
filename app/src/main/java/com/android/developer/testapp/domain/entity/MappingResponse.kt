package com.android.developer.testapp.domain.entity

import com.android.developer.testapp.common.Constants
import com.android.developer.testapp.presentation.adapter.recycler.ItemType

data class MappingResponse(val totalItems: Int,
                           val items: MutableList<ItemType> = arrayListOf()) {

    data class Text(val type: String,
                    val title: String,
                    val message: String,
                    val authorName: String,
                    val authorAvatar: String): ItemType {

        override fun getType(): Int {
            return Constants.TYPE_TEXT
        }
    }

    data class Image(val type: String,
                     val title: String,
                     val imageUrl1: String,
                     val imageTitle1: String,
                     val imageUrl2: String,
                     val imageTitle2: String,
                     val imageUrl3: String,
                     val imageTitle3: String,
                     val authorName: String,
                     val authorAvatar: String): ItemType {

        override fun getType(): Int {
            return Constants.TYPE_IMAGE
        }
    }
}