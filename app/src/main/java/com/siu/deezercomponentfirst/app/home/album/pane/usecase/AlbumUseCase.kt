package com.siu.deezercomponentfirst.app.home.album.pane.usecase


import com.siu.deezercomponentfirst.app.home.album.pane.presenter.AlbumPresenter
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsRepository
import com.siu.deezercomponentfirst.tools.library.rxjava.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class AlbumUseCase(
    mFeedsRepository: FeedsRepository,
    mSchedulerProvider: BaseSchedulerProvider,
    val albumPresenter: AlbumPresenter,
    val albumId: Int,
    feedId: String = "2529"

) {

    private val mDisposables = CompositeDisposable()

    private val disposer = mFeedsRepository
        .getFeed(feedId)
        .subscribeOn(mSchedulerProvider.io())
        .observeOn(mSchedulerProvider.ui())
        .doOnSuccess {
            albumPresenter.render(it.first { data -> data.id == albumId })
        }
        .doOnError {
            albumPresenter.render(null)
        }
        .subscribe()

    fun init() {
        initLoading()
    }

    private fun initLoading() {
         mDisposables.add(disposer)
    }

}
