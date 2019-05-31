package com.android.developer.testapp.presentation.mvp.view.base

import com.android.developer.testapp.presentation.adapter.recycler.ItemType

interface ViewMain : MvpView {

    fun notifyData(list: List<ItemType>)
}