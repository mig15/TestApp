package com.android.developer.testapp.data.entity

data class MainResponse(val totalItems: Int,
                        val items: MutableList<Item>) {

    data class Item(val type: String,
                    val title: String,
                    val message: String,
                    val authorName: String,
                    val authorAvatar: String,
                    val imageUrl1: String,
                    val imageTitle1: String,
                    val imageUrl2: String,
                    val imageTitle2: String,
                    val imageUrl3: String,
                    val imageTitle3: String)
}