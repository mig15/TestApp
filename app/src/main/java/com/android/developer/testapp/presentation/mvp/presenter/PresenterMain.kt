package com.android.developer.testapp.presentation.mvp.presenter

import com.android.developer.testapp.common.Constants
import com.android.developer.testapp.common.utils.logcat
import com.android.developer.testapp.domain.entity.MappingResponse
import com.android.developer.testapp.domain.interactor.MainInteractor
import com.android.developer.testapp.domain.interactor.base.DefaultObserver
import com.android.developer.testapp.presentation.mvp.presenter.base.BasePresenter
import com.android.developer.testapp.presentation.mvp.view.base.ViewMain

class PresenterMain(private val case: MainInteractor) : BasePresenter<ViewMain>() {

    override fun viewReady() {
        requestPage()
    }

    fun unsubscribe() {
        case.dispose()
    }

    private fun requestPage() {
        case.execute(ResponseObserver(), MainInteractor.Data.setData(0))
    }

    private inner class ResponseObserver : DefaultObserver<MappingResponse>() {

        override fun onComplete() {
        }

        override fun onNext(t: MappingResponse) {
            logcat("size = ${t.items.size}")
            for (item in t.items) {
                when (item.getType()) {
                    Constants.TYPE_TEXT -> {
                        item as MappingResponse.Text
                    }
                    Constants.TYPE_IMAGE -> {
                        item as MappingResponse.Image
                    }
                }
            }
        }

        override fun onError(e: Throwable) {
            logcat("onError: $e")
        }
    }
}