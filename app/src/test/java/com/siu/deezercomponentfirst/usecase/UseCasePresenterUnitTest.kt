package com.siu.deezercomponentfirst.usecase

import com.siu.deezer.injection.Injection
import com.siu.deezercomponentfirst.app.home.feed.pane.presenter.FeedPresenterInterface
import com.siu.deezercomponentfirst.app.home.feed.pane.usecase.FeedUseCase
import com.siu.deezercomponentfirst.app.home.feed.pane.viewmodel.FeedsViewState
import com.siu.deezercomponentfirst.domain.repository.feed.response.Album
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UseCasePresenterUnitTest {

    @Mock
    private lateinit var mPresenter: FeedPresenterInterface

    @InjectMocks
    private lateinit var mFeedPresenter: FeedUseCase

    @Before
    fun setupTasksViewModel() {
        MockitoAnnotations.initMocks(this)

        mFeedPresenter = FeedUseCase(
            Injection.provideFeedsRepository(),
            Injection.provideSchedulerProvider(),
            mPresenter
        )
    }

    @Test
    fun showFeed_FromPresenterThroughViewState() {
        val albums = arrayListOf(Album())

        mFeedPresenter.init()


        Mockito.verify(mPresenter).render(FeedsViewState(false, it))
        Mockito.verify(mViewEmpty).show(null)

    }


}

