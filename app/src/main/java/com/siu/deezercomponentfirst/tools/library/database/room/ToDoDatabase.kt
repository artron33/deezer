//package com.siu.deezer.Albums.source.local.room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.siu.deezercomponentfirst.Albums.domain.feed.response.Feed
//import com.siu.deezer.Albums.source.local.room.feed.FeedsDao
//
//
//@Database(entities = [Feed::class], version = 1)
//abstract class ToDoDatabase : RoomDatabase() {
//
//    abstract fun taskDao(): FeedsDao
//
//    companion object {
//
//        private var INSTANCE: ToDoDatabase? = null
//
//        private val lock = Any()
//
//        fun getInstance(context: Context): ToDoDatabase {
//            synchronized(lock) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.applicationContext,
//                            ToDoDatabase::class.java, "Feeds.db")
//                            .build()
//                }
//                return INSTANCE!!
//            }
//        }
//    }
//
//}