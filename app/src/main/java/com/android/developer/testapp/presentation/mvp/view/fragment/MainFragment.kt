package com.android.developer.testapp.presentation.mvp.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.developer.testapp.R
import com.android.developer.testapp.data.repository.RepositoryImpl
import com.android.developer.testapp.domain.interactor.MainInteractor
import com.android.developer.testapp.presentation.adapter.recycler.ItemType
import com.android.developer.testapp.presentation.adapter.recycler.RecyclerAdapter
import com.android.developer.testapp.presentation.adapter.recycler.renderer.ImageRenderer
import com.android.developer.testapp.presentation.adapter.recycler.renderer.TextRenderer
import com.android.developer.testapp.presentation.mvp.presenter.PresenterMain
import com.android.developer.testapp.presentation.mvp.view.base.ViewMain
import kotlinx.android.synthetic.main.content_main.view.*

class MainFragment : Fragment(), ViewMain {

    private val title = "Лента"

    private lateinit var presenter: PresenterMain
    private lateinit var v: View
    private lateinit var adapter: RecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = RepositoryImpl()
        val case = MainInteractor(repository)
        presenter = PresenterMain(case)

        adapter = RecyclerAdapter()
        adapter.registerRenderer(TextRenderer())
        adapter.registerRenderer(ImageRenderer())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.content_main, container, false)

        presenter.attachView(this)

        v.tv_title.text = title

        v.recycler.adapter = adapter
        layoutManager = LinearLayoutManager(context)
        v.recycler.layoutManager = layoutManager
        v.recycler.addOnScrollListener(onRecyclerScroll)

        presenter.viewReady()

        return v
    }

    override fun notifyData(list: List<ItemType>) {
        adapter.notifyData(list)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private val onRecyclerScroll = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            if (dy > 0) {
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

                //Если на экране уже видны все элементы
                if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                    presenter.requestPage()
                }
            }
        }
    }

    override fun onDestroy() {
        presenter.unsubscribe()
        presenter.detachView()

        super.onDestroy()
    }
}