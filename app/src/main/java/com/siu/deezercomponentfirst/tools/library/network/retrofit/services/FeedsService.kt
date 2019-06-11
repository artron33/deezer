package com.siu.deezercomponentfirst.tools.library.network.retrofit.services


import com.siu.deezercomponentfirst.domain.repository.feed.response.Feed
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FeedsService {

    @GET("user/{album}/albums")
    fun feed(@Path("album") album: String = "2529", @Query("index") range: Int): Single<Feed>

}
