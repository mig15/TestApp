package com.android.developer.testapp.presentation.mvp.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.developer.testapp.R
import com.android.developer.testapp.presentation.extension.changeFragmentWithoutBackStack
import com.android.developer.testapp.presentation.mvp.view.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragmentWithoutBackStack(MainFragment(), R.id.container)
    }
}
