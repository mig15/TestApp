package com.android.developer.testapp.data.net

import com.android.developer.testapp.data.entity.MainResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerApi {

    @GET("post/list?")
    fun requestPage(@Query("page") page: Int): Observable<MainResponse>
}