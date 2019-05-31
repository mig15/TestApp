package com.android.developer.testapp.domain.repository

import com.android.developer.testapp.data.entity.MainResponse
import io.reactivex.Observable

interface Repository {

    fun requestPage(page: Int): Observable<MainResponse>
}