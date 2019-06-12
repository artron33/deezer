package com.siu.deezercomponentfirst.data.repository

import androidx.annotation.VisibleForTesting
import com.siu.deezercomponentfirst.data.net.response.Album
import com.siu.deezercomponentfirst.data.net.response.Feed
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsDataSource
import com.siu.deezercomponentfirst.tools.library.network.retrofit.services.FeedsService
import io.reactivex.Maybe

class FeedRepositoryNetwork(val service: FeedsService) : FeedsDataSource.Network {

    private var index = 0
    private val mAlbums: MutableList<Album> = mutableListOf()

    override fun getFeed(feedId: String): Maybe<MutableList<Album>> {
        var remoteFeed = Maybe.just(mAlbums.toMutableList())
        if (doesFullDataLoaded()) {
            return remoteFeed
        }
        remoteFeed = getFeedNetwork(feedId)
            .onErrorReturnItem(INTERNET_ISSUE_DATA)
            .doOnSuccess { feed ->

                //todo build a system to avoid request when no connection
                if (!feed.checksum.isNullOrEmpty()) {
                    val tempIndex = feed.next
                        .substringAfterLast("index=")
                        .toIntOrNull() ?: FULL_LOADED

                    if (tempIndex == index) {
                        //Then we has a double request
                    } else {
                        index = tempIndex
                        mAlbums.addAll(feed.data)
                    }
                }

            }.doOnError {
                it.printStackTrace()

            }.map<MutableList<Album>> {
                mAlbums.toMutableList()
            }

        return remoteFeed
    }

    @VisibleForTesting
    fun doesFullDataLoaded() = index == FULL_LOADED

    private fun getFeedNetwork(feedId: String): Maybe<Feed> {
        return service.feed(feedId, index)
    }

    companion object {
        const val FULL_LOADED = -1

        val INTERNET_ISSUE_DATA = Feed()
    }

}
