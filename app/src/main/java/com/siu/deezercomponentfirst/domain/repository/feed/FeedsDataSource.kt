package com.siu.deezercomponentfirst.domain.repository.feed

import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import com.siu.deezercomponentfirst.domain.repository.feed.response.Feed
import io.reactivex.Completable
import io.reactivex.Single


interface FeedsDataSource {

    interface Network {
        fun getFeed(feedId: String): Single<MutableList<Album>>

    }

    interface Local {
        fun getFeed(feedId: String): Single<Feed>

        fun saveFeed(task: Feed): Completable

        fun deleteFeed(feedId: String): Completable

    }

    fun getFeed(feedId: String): Single<MutableList<Album>>

    fun saveFeed(task: Feed): Completable

    fun refreshFeeds()

    fun deleteFeed(feedId: String): Completable

}
