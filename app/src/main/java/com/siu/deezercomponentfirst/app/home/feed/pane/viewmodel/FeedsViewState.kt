package com.siu.deezercomponentfirst.app.home.feed.pane.viewmodel

import com.siu.deezercomponentfirst.domain.repository.feed.response.Album

data class FeedsViewState(
    val isLoading: Boolean,
    val feeds: List<Album> = ArrayList(),
    val error: Throwable? = null
)  {

    companion object {

        internal fun idle(): FeedsViewState {
            return FeedsViewState(
                isLoading = (false),
                error = (null)
            )
        }

        internal fun failure(error: Throwable?): FeedsViewState {
            return FeedsViewState(
                isLoading = (false),
                error = (error)
            )
        }
    }

}
