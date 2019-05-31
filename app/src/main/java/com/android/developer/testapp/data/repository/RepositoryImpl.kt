package com.android.developer.testapp.data.repository

import com.android.developer.testapp.data.entity.MainResponse
import com.android.developer.testapp.data.net.RetrofitBuilder
import com.android.developer.testapp.domain.repository.Repository
import io.reactivex.Observable

class RepositoryImpl : Repository {

    override fun requestPage(page: Int): Observable<MainResponse> {
        return RetrofitBuilder.serverApi.requestPage(page)
    }
}