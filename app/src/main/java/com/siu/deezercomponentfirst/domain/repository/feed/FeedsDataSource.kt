package com.siu.deezercomponentfirst.domain.repository.feed

import com.siu.deezercomponentfirst.data.net.response.Album
import com.siu.deezercomponentfirst.data.net.response.Feed
import io.reactivex.Completable
import io.reactivex.Maybe


interface FeedsDataSource {

    interface Network {
        fun getFeed(feedId: String): Maybe<MutableList<Album>>

    }

    interface Local {
        fun getFeed(feedId: String): Maybe<Feed>

        fun saveFeed(task: Feed): Completable

        fun deleteFeed(feedId: String): Completable

    }

    fun getFeed(feedId: String): Maybe<MutableList<Album>>

    fun saveFeed(task: Feed): Completable

    fun refreshFeeds()

    fun deleteFeed(feedId: String): Completable

}
