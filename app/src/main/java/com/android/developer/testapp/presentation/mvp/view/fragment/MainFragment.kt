package com.android.developer.testapp.presentation.mvp.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.developer.testapp.R
import com.android.developer.testapp.presentation.mvp.presenter.PresenterMain
import com.android.developer.testapp.presentation.mvp.view.base.ViewMain

class MainFragment : Fragment(), ViewMain {

    private lateinit var presenter: PresenterMain
    private lateinit var v: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = PresenterMain()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.content_main, container, false)

        presenter.attachView(this)
        presenter.viewReady()

        return v
    }

    override fun onDestroy() {
        presenter.detachView()

        super.onDestroy()
    }
}