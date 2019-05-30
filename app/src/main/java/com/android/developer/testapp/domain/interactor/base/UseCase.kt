package com.android.developer.testapp.domain.interactor.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, in Params> {

    private var subscription: DisposableObserver<T>? = null

    abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun dispose() {
        subscription?.dispose()
    }

    fun execute(observer: DisposableObserver<T>, params: Params) {
        subscription = observer
        this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscription!!)
    }
}