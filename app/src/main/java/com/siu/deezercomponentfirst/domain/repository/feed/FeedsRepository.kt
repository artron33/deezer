package com.siu.deezercomponentfirst.domain.repository.feed

import androidx.annotation.VisibleForTesting
import com.google.common.base.Preconditions.checkNotNull
import com.siu.deezercomponentfirst.data.net.response.Album
import com.siu.deezercomponentfirst.data.net.response.Feed
import io.reactivex.Completable
import io.reactivex.Maybe


class FeedsRepository// Prevent direct instantiation.
private constructor(
    feedsRemoteDataSource: FeedsDataSource.Network
) : FeedsDataSource {

    private val mFeedDataNetwork: FeedsDataSource.Network = checkNotNull(feedsRemoteDataSource)

    override fun saveFeed(feed: Feed): Completable {
        checkNotNull<Any>(feed)
        return Completable.complete()
    }
    override fun deleteFeed(feedId: String): Completable {
        checkNotNull(feedId)
        return Completable.complete()
    }

    /**
     * Gets feeds from local Albums source (sqlite) unless the table is new or empty. In that case it
     * uses the network Albums source. This is done to simplify the sample.
     */
    override fun getFeed(feedId: String): Maybe<MutableList<Album>> {
        return mFeedDataNetwork.getFeed(feedId)
    }

    override fun refreshFeeds() { }

    companion object {
        private var INSTANCE: FeedsRepository? = null

        @JvmStatic
        fun getInstance(
            feedsRemoteDataSource: FeedsDataSource.Network
        ): FeedsRepository {
            if (INSTANCE == null) {
                synchronized(FeedsRepository::javaClass) {
                    INSTANCE =
                        FeedsRepository(feedsRemoteDataSource)
                }
            }
            return INSTANCE!!
        }

        /**
         * not used yet
         */
        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}
