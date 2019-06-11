package com.siu.deezercomponentfirst.presenter

import com.siu.deezercomponentfirst.app.home.feed.pane.presenter.FeedPresenter
import com.siu.deezercomponentfirst.app.home.feed.pane.viewmodel.FeedsViewState
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewBase
import com.siu.deezercomponentfirst.tools.architecture.mvp.view.ViewEventBase
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class FeedPresenterUnitTest {

    @Mock
    private lateinit var mEventBaseOkFeed: ViewEventBase
    @Mock
    private lateinit var mViewOkFeed: ViewBase<List<Album>>
    @Mock
    private lateinit var mEventBaseEmptyFeed: ViewEventBase
    @Mock    private lateinit var mViewEmpty: ViewBase<Any?>

    @InjectMocks
    private lateinit var mFeedPresenter: FeedPresenter

    @Before
    fun setupTasksViewModel() {
        MockitoAnnotations.initMocks(this)

        mFeedPresenter = FeedPresenter(
            feedOkViewEventBase = mEventBaseOkFeed,
            feedOkView = mViewOkFeed,
            feedEmptyViewEventBase = mEventBaseEmptyFeed,
            feedEmptyView = mViewEmpty
        )
    }

    @Test
    fun showFeed_FromPresenterThroughViewState() {
        val albums = arrayListOf(Album())

        mFeedPresenter.render(FeedsViewState(false, albums))

        verify(mViewOkFeed).show(albums)
        verify(mViewEmpty).show(null)
    }

    @Test
    fun showNoFeed_FromPresenterThroughViewState() {
        mFeedPresenter.render(FeedsViewState(true, ArrayList()))

        verify(mViewOkFeed).showNos()
        verify(mViewEmpty).showNos()
    }

    @Test
    fun showLoadingError_FromPresenterThroughViewState() {
        mFeedPresenter.render(FeedsViewState(false, arrayListOf(Album()), Throwable("Errror test")) )

        verify(mViewOkFeed).showLoadingError()
        verify(mViewEmpty).showLoadingError()
    }

}

