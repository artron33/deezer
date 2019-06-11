package com.siu.deezercomponentfirst.tools.library.network.retrofit

import com.siu.deezercomponentfirst.BuildConfig.SERVER_URL
import com.siu.deezercomponentfirst.tools.library.network.retrofit.services.FeedsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitRepo {

    var feedsService: FeedsService
        private set

    companion object {

        private var INSTANCE: RetrofitRepo? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         *
         * @param tasksRemoteDataSource the backend Albums source
         * @param tasksLocalDataSource  the device storage Albums source
         * @return the [RetrofitRepo] instance
         */
        fun getInstance(): RetrofitRepo {
            return INSTANCE.let { feedRepository ->
                feedRepository ?:
                RetrofitRepo()

            }
        }
        private val ENDPOINT_VERSION = "2.0/"
        private val ENDPOINT_BASE = SERVER_URL + ENDPOINT_VERSION
    }

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder()
            .baseUrl(ENDPOINT_BASE)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        feedsService = retrofit.create(FeedsService::class.java)
    }

}
