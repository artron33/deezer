package com.siu.deezercomponentfirst.app.home.feed.pane.views.empty

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import com.google.android.material.snackbar.Snackbar
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.home.feed.pane.FeedPane
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewBase
import kotlinx.android.synthetic.main.feed_data_error.view.*

class EmptyFeedView(
    feedPane: FeedPane

): ViewBase<Any?> {

    private val mNoFeedsView: View          = feedPane.noTasks
    private val mNoFeedIcon: ImageView      = feedPane.noTasksIcon
    private val mNoFeedMainView: TextView   = feedPane.noTasksMain
    private val mNoFeedAddView: TextView    = feedPane.noTasksAdd
    private val mGroup: Group               = feedPane.empty_feed_group


    override fun showLoadingError() {
        val view =  mNoFeedsView
        Snackbar.make(view, view.resources.getString(R.string.feed_empty_loading_feeds_error), Snackbar.LENGTH_LONG).show()
    }

    override fun showNos() {
        showNoFeedsViews()
    }

    override fun show(ignored: Any?) {
        hide()
    }

    fun showNoFeedsViews() {
        mGroup.visibility = View.VISIBLE

        mNoFeedMainView.text = mNoFeedAddView.resources.getString(R.string.feed_empty_no_feeds_all)
        mNoFeedIcon.setImageDrawable(mNoFeedAddView.resources.getDrawable(R.drawable.notification_bg, null))
        mNoFeedAddView.visibility = if (true) View.VISIBLE else View.GONE
    }

    private fun hide() {
        mGroup.visibility = View.GONE
    }

}