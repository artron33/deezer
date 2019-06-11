package com.siu.deezercomponentfirst.app.home.feed.pane.presenter


import com.siu.deezercomponentfirst.app.home.feed.pane.viewmodel.FeedsViewState
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import com.siu.deezercomponentfirst.tools.architecture.mvp.presenter.PresenterBase
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewBase
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewEventBase


interface FeedPresenterInterface : PresenterBase<FeedsViewState> {
    fun setLoadMore(loadMore: () -> Unit)
}

class FeedPresenter(
    val feedEmptyView: ViewBase<Any?>,
    val feedEmptyViewEventBase: ViewEventBase,
    val feedOkView: ViewBase<List<Album>>,
    val feedOkViewEventBase: ViewEventBase

) : FeedPresenterInterface {
    /**
     * to me, i'd prefere link the event part to the
     * UseCase part,
     * Instead of useing the presenter
     */
    override fun setLoadMore(loadMore: () -> Unit) {
        feedOkViewEventBase.setLoadMore(loadMore)
        feedEmptyViewEventBase.setLoadMore(loadMore)
    }

    override fun render(state: FeedsViewState) {
        if (state.error != null) {
            showLoadingFeedsError()
            return
        }
        if (state.feeds.isEmpty()) {
            showNoFeeds()

        } else {
            showFeed(state.feeds)
        }
    }

    private fun showNoFeeds() {
        feedOkView.showNos()
        feedEmptyView.showNos()
    }

    private fun showLoadingFeedsError() {
        feedOkView.showLoadingError()
        feedEmptyView.showLoadingError()
    }

    private fun showFeed(albums: List<Album>) {
        feedOkView.show(albums)
        feedEmptyView.show(null)
    }


}
