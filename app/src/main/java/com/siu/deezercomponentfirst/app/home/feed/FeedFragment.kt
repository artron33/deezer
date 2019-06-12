package com.siu.deezercomponentfirst.app.home.feed


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.siu.deezercomponentfirst.app.home.feed.pane.FeedPane
import com.siu.deezercomponentfirst.data.net.response.Feed


/**
 * Display a grid of [Feed]s. User can choose to view all, active or completed feeds.
 */
class FeedFragment : Fragment() {

    var viewPane: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewPane = viewPane ?: FeedPane(context!!,
            activity = activity as AppCompatActivity)
        return viewPane
    }

    companion object {
        fun newInstance(): FeedFragment {
            return FeedFragment()
        }
    }

}
