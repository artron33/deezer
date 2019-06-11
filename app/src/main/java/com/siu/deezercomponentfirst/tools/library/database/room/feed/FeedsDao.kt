//package com.siu.deezer.Albums.source.local.room.feed
//
//import androidx.room.*
//import com.siu.deezercomponentfirst.Albums.domain.feed.response.Feed
//import io.reactivex.Completable
//import io.reactivex.Single
//
//
///**
// * Album Access Object for the tasks table.
// */
//@Dao interface FeedsDao {
//
//    /**
//     * Select all tasks from the tasks table.
//     *
//     * @return all tasks.
//     */
//    @Query("SELECT * FROM Feeds") fun getFeed(): Single<Feed>
//
//    /**
//     * Select a task by id.
//     *
//     * @param taskId the task id.
//     * @return the task with taskId.
//     */
//    @Query("SELECT * FROM Feeds WHERE checksum = :taskId") fun getFeedById(taskId: String): Feed?
//
//    /**
//     * Insert a task in the database. If the task already exists, replace it.
//     *
//     * @param task the task to be inserted.
//     */
//    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertFeed(task: Feed): Completable
//
//    /**
//     * Update a task.
//     *
//     * @param task task to be updated
//     * @return the number of tasks updated. This should always be 1.
//     */
//    @Update fun updateFeed(task: Feed): Int
//
//    /**
//     * Delete a task by id.
//     *
//     * @return the number of tasks deleted. This should always be 1.
//     */
//    @Query("DELETE FROM Feeds WHERE checksum = :taskId") fun deleteFeedById(taskId: String): Completable
//
//    /**
//     * Delete all tasks.
//     */
//    @Query("DELETE FROM Feeds") fun deleteFeeds()
//}