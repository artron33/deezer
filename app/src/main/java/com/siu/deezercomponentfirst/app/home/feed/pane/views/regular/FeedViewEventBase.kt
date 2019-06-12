package com.siu.deezercomponentfirst.app.home.feed.pane.views.regular

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.siu.deezercomponentfirst.app.home.feed.pane.FeedPane
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewEventBase
import kotlinx.android.synthetic.main.feed_data_ok.view.*

class FeedViewEventBase(
    feedPane: FeedPane

) : ViewEventBase {

    private val recyclerView = feedPane.feed_recycler

    override fun setLoadMore(loadMore: () -> Unit) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                shouldLoadMore(loadMore)
            }
        })
    }

    private fun shouldLoadMore(loadMore: () -> Unit) {
        val linearLayoutManager = recyclerView.layoutManager as GridLayoutManager
        if (linearLayoutManager.itemCount <= linearLayoutManager.findLastVisibleItemPosition() + 2 ) {
            loadMore()
        }
    }

}
