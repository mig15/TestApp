package com.android.developer.testapp.presentation.mvp.presenter.base

import com.android.developer.testapp.presentation.mvp.view.base.MvpView

abstract class BasePresenter<T : MvpView> : MvpPresenter<T> {

    private var view: T? = null

    override fun attachView(mvpView: T) {
        view = mvpView
    }

    override fun detachView() {
        view = null
    }

    fun getView() = view
}