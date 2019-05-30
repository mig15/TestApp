package com.android.developer.testapp.presentation.mvp.presenter.base

import com.android.developer.testapp.presentation.mvp.view.base.MvpView

interface MvpPresenter<V : MvpView> {

    fun attachView(mvpView: V)
    fun viewReady()
    fun detachView()
}