package com.android.developer.testapp.data.mapper

import com.android.developer.testapp.common.Constants
import com.android.developer.testapp.data.entity.MainResponse
import com.android.developer.testapp.domain.entity.MappingResponse
import com.android.developer.testapp.presentation.adapter.recycler.ItemType
import java.lang.RuntimeException

class mapper {

    fun transform(response: MainResponse): MappingResponse {
        val mappingResponse = MappingResponse(response.totalItems)

        for (item in response.items) {
            val data: ItemType = when (item.type) {
                Constants.TEXT -> {
                    MappingResponse.Text(type = item.type,
                        title = item.title,
                        message = item.message,
                        authorName = item.authorName,
                        authorAvatar = item.authorAvatar)
                }
                Constants.IMAGE -> {
                    MappingResponse.Image(type = item.type,
                        title = item.title,
                        imageTitle1 = item.imageTitle1,
                        imageUrl1 = item.imageUrl1,
                        imageTitle2 = item.imageTitle2,
                        imageUrl2 = item.imageUrl2,
                        imageTitle3 = item.imageTitle3,
                        imageUrl3 = item.imageUrl3,
                        authorName = item.authorName,
                        authorAvatar = item.authorAvatar)
                }
                else -> throw RuntimeException("Unknown type")
            }

            mappingResponse.items.add(data)
        }

        return mappingResponse
    }
}