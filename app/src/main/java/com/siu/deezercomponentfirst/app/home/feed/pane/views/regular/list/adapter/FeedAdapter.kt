package com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.list.adapter

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.siu.deezercomponentfirst.app.home.feed.pane.FeedPane
import com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.list.row.FeedRow
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import kotlinx.android.synthetic.main.pane_feed.view.*
import java.lang.ref.WeakReference

class FeedAdapter(
    val weakActivity: WeakReference<AppCompatActivity>,
    feedPane: FeedPane

) :  ListAdapter<Album, FeedAdapter.FeedViewHolder> (
    ElementDiffCallback()
) {

    val deezerIcon = feedPane.deezer_icon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            FeedRow(parent.context, parent = parent)
        )
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.row.bindPage(
            weakActivity,
            FeedRowViewModel(getItem(position), deezerIcon = deezerIcon, position = position)
        )
    }

    class FeedViewHolder(
        val row: FeedRow
    ) : RecyclerView.ViewHolder(row)

    data class FeedRowViewModel(
        val album: Album,
        val deezerIcon: View,
        val position: Int
    )

}
