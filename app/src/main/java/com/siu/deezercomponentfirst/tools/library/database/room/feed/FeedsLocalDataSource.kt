//package com.siu.deezer.Albums.source.local.room.feed
//
//import androidx.annotation.VisibleForTesting
//
//import com.siu.deezercomponentfirst.Albums.domain.feed.FeedsDataSource
//import com.siu.deezercomponentfirst.Albums.domain.feed.response.Feed
//import io.reactivex.Completable
//import io.reactivex.Single
//
//
///**
// * Concrete implementation of a Albums source as a db.
// */
//class FeedsLocalDataSource private constructor(
//        val feedsDao: FeedsDao
//) : FeedsDataSource.Local {
//    override fun getFeed(feedId: String): Single<Feed> {
//        return feedsDao.getFeed()
//    }
//
//
//    override fun saveFeed(task: Feed): Completable {
//        return feedsDao.insertFeed(task)
//    }
//
//    override fun deleteFeed(feedId: String): Completable {
//        return feedsDao.deleteFeedById(feedId)
//    }
//
////
////    override fun refreshFeeds() {
////        feedsDao.deleteFeeds()
////        feedsDao.getFeed()
////    }
////
////    override fun deleteAllFeeds() {}
////
////    /**
////     * Note: [FeedsDataSource.LoadFeedsCallback.onDataNotAvailable] is fired if the database doesn't exist
////     * or the table is empty.
////     */
////    override fun getFeed(callback: FeedsDataSource.Local) {
//////        appExecutors.diskIO.execute {
////    }
//
//    companion object {
//        private var INSTANCE: FeedsLocalDataSource? = null
//
//        @JvmStatic
//        fun getInstance(feedsDao: FeedsDao): FeedsLocalDataSource {
//            if (INSTANCE == null) {
//                synchronized(FeedsLocalDataSource::javaClass) {
//                    INSTANCE =
//                        FeedsLocalDataSource(feedsDao)
//                }
//            }
//            return INSTANCE!!
//        }
//
//        @VisibleForTesting
//        fun clearInstance() {
//            INSTANCE = null
//        }
//    }
//}
