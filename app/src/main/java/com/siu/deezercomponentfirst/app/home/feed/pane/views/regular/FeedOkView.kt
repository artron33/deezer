package com.siu.deezercomponentfirst.app.home.feed.pane.views.regular

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.siu.deezercomponentfirst.BuildConfig
import com.siu.deezercomponentfirst.app.home.feed.pane.FeedPane
import com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.list.adapter.FeedAdapter
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewBase
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import kotlinx.android.synthetic.main.feed_data_ok.view.*
import java.lang.ref.WeakReference


class FeedOkView(
    val feedPane: FeedPane,
    weakActivity: WeakReference<AppCompatActivity>
) : ViewBase<List<Album>> {


    private var mAdapter: FeedAdapter = FeedAdapter(weakActivity, feedPane = feedPane)

    private fun setData(albums: List<Album>) {
        val newList = ArrayList<Album>()
        albums.forEach { newList.add(newList.size, it) }
        mAdapter.submitList(newList)
        feedPane.feed_group.visibility = View.VISIBLE
    }

    private fun hide() {
        feedPane.feed_group.visibility = View.GONE
    }

    init {
         val gridLayoutManager = GridLayoutManager(feedPane.context, BuildConfig.COLUM_NUMBER.toInt())

        feedPane.feed_recycler.layoutManager = gridLayoutManager
        feedPane.feed_recycler.adapter = mAdapter
    }

    override fun showLoadingError() {

    }

    override fun showNos() {
        hide()
    }

    override fun show(albums: List<Album>) {
        setData(albums)
    }

}
