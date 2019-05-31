package com.android.developer.testapp.presentation.mvp.presenter

import com.android.developer.testapp.common.utils.logcat
import com.android.developer.testapp.domain.entity.MappingResponse
import com.android.developer.testapp.domain.interactor.MainInteractor
import com.android.developer.testapp.domain.interactor.base.DefaultObserver
import com.android.developer.testapp.presentation.mvp.presenter.base.BasePresenter
import com.android.developer.testapp.presentation.mvp.view.base.ViewMain

class PresenterMain(private val case: MainInteractor) : BasePresenter<ViewMain>() {

    private var wasRequest = false
    private var lastPage = 0
    private var totalItems = 0
    private var gettingItemsAmount = 0

    override fun viewReady() {
        requestPage()
    }

    fun unsubscribe() {
        case.dispose()
    }

    fun requestPage() {
        if (!wasRequest) {
            if (gettingItemsAmount < totalItems || gettingItemsAmount == 0) {
                case.execute(ResponseObserver(), MainInteractor.Data.setData(lastPage))
                wasRequest = true
                lastPage++
            }
        }
    }

    private inner class ResponseObserver : DefaultObserver<MappingResponse>() {

        override fun onComplete() {
            wasRequest = false
        }

        override fun onNext(t: MappingResponse) {
            totalItems = t.totalItems
            gettingItemsAmount += t.items.size
            getView()?.notifyData(t.items)
        }

        override fun onError(e: Throwable) {
            logcat("$e")
            getView()?.showMessage("Ой, что-то пошло не так")
            wasRequest = false
        }
    }
}