package com.siu.deezercomponentfirst.data.repository

import com.siu.deezercomponentfirst.domain.repository.feed.FeedsDataSource
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import com.siu.deezercomponentfirst.domain.repository.feed.response.Feed
import com.siu.deezercomponentfirst.tools.library.network.retrofit.RetrofitRepo
import io.reactivex.Single

class FeedRepositoryNetwork : FeedsDataSource.Network {

    private var index = 0
    private val mAlbums: MutableList<Album> = mutableListOf()

    override fun getFeed(feedId: String): Single<MutableList<Album>> {
        var remoteFeed = Single.just(mAlbums.toMutableList())
        if (index == FULL_LOADED) {
            return remoteFeed
        }
        remoteFeed = getFeedNetwork(feedId)
            .onErrorReturnItem(Feed())
            .doOnSuccess { feed ->
                val tempIndex = feed.next
                    .substringAfterLast("index=")
                    .toIntOrNull() ?: FULL_LOADED


                if (tempIndex == index) {
                    //Then we has a double request
                } else {
                    index = tempIndex
                    mAlbums.addAll(feed.data)
                }

            }.doOnError {
                println("----------------------$it")
                it.printStackTrace()

            }.map<MutableList<Album>> {
                mAlbums.toMutableList()
            }

        return remoteFeed
    }

    private fun getFeedNetwork(feedId: String): Single<Feed> {
        return RetrofitRepo.getInstance().feedsService.feed(feedId, index)
    }

    companion object {
        const val FULL_LOADED = -1
    }

}
