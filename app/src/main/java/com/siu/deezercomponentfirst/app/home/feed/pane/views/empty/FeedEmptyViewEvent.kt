package com.siu.deezercomponentfirst.app.home.feed.pane.views.empty

import android.widget.LinearLayout
import com.siu.deezercomponentfirst.app.home.feed.pane.FeedPane
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewEventBase
import kotlinx.android.synthetic.main.feed_data_error.view.*

class FeedEmptyViewEvent(
    feedPane: FeedPane

)  : ViewEventBase {

    private val mNoFeedAddView: LinearLayout = feedPane.noTasks

    override fun setLoadMore(loadMore: () -> Unit) {
        mNoFeedAddView.setOnClickListener { loadMore() }
    }

}