package com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album

class ElementDiffCallback : DiffUtil.ItemCallback<Album>() {

    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return newItem.title == oldItem.title && newItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return newItem == oldItem
    }

}
