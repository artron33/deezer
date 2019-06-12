package com.siu.deezercomponentfirst.app.home.feed.pane

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import com.siu.deezer.injection.Injection
import com.siu.deezercomponentfirst.R
import com.siu.deezercomponentfirst.app.custom.generic.GenericPane
import com.siu.deezercomponentfirst.app.home.feed.pane.presenter.FeedPresenter
import com.siu.deezercomponentfirst.app.home.feed.pane.usecase.FeedUseCase
import com.siu.deezercomponentfirst.app.home.feed.pane.views.empty.FeedEmptyView
import com.siu.deezercomponentfirst.app.home.feed.pane.views.empty.FeedEmptyViewEvent
import com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.FeedOkView
import com.siu.deezercomponentfirst.app.home.feed.pane.views.regular.FeedViewEventBase
import java.lang.ref.WeakReference


class FeedPane @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    activity: AppCompatActivity
) : GenericPane(context, attrs, defStyleAttr) {

    val feedOkView by lazy { FeedOkView(
        this,
        WeakReference(activity)
    ) }
    val feedEmptyView by lazy { FeedEmptyView(this) }
    val feedEmptyViewEvent by lazy { FeedEmptyViewEvent(this) }

    val feedUseCase by lazy {
        FeedUseCase(
            Injection.provideFeedsRepository(),
            Injection.provideSchedulerProvider(),
            FeedPresenter(
                feedOkViewEventBase = FeedViewEventBase(this),
                feedOkView = feedOkView,
                feedEmptyView = feedEmptyView,
                feedEmptyViewEventBase = feedEmptyViewEvent
            )
        )
    }

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    init {
        inflate(context, R.layout.pane_feed,  this)
        feedUseCase.init()
    }

}
