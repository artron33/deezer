package com.siu.deezercomponentfirst.app.home.feed.pane.usecase


import com.siu.deezercomponentfirst.app.home.feed.pane.presenter.FeedPresenterInterface
import com.siu.deezercomponentfirst.app.home.feed.pane.viewmodel.FeedsViewState
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsRepository
import com.siu.deezercomponentfirst.tools.architecture.mvp.usecase.BaseUseCase
import com.siu.deezercomponentfirst.tools.library.rxjava.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class FeedUseCase (
    val mFeedsRepository: FeedsRepository,
    val mSchedulerProvider: BaseSchedulerProvider,
    val feedPresenter: FeedPresenterInterface,
    val feedId: String = "2529"

) : BaseUseCase {

    private val mDisposables = CompositeDisposable()
    private val disposer = {
        mFeedsRepository
            .getFeed(feedId)
            .subscribeOn(mSchedulerProvider.io())
            .observeOn(mSchedulerProvider.ui())
            .doOnSuccess {
                feedPresenter.render(FeedsViewState(false, it))
            }
            .doOnError {
                feedPresenter.render(FeedsViewState(false, error = it))

            }.subscribe()
    }


    override fun init() {
        feedPresenter.setLoadMore { load() }
        initLoading()

    }

    private fun initLoading() {
         mDisposables.add(disposer.invoke())

    }

    private fun load() {
        mDisposables.add(disposer.invoke())

    }

}
