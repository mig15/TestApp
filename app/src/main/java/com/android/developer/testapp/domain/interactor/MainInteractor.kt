package com.android.developer.testapp.domain.interactor

import com.android.developer.testapp.data.mapper.Mapper
import com.android.developer.testapp.domain.entity.MappingResponse
import com.android.developer.testapp.domain.interactor.base.UseCase
import com.android.developer.testapp.domain.repository.Repository
import io.reactivex.Observable

class MainInteractor(private val repository: Repository) : UseCase<MappingResponse, MainInteractor.Data>() {

    override fun buildUseCaseObservable(params: Data): Observable<MappingResponse> {
        val mapper = Mapper()
        return repository.requestPage(params.page).map { mapper.transform(it) }
    }

    class Data(val page: Int) {
        companion object {
            fun setData(page: Int) = Data(page)
        }
    }
}