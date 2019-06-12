package com.siu.deezercomponentfirst.tools.library.network.retrofit.services


import com.siu.deezercomponentfirst.data.net.response.Feed
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FeedsService {

    @GET("user/{album}/albums")
    fun feed(@Path("album") album: String = "2529", @Query("index") range: Int): Maybe<Feed>

}
