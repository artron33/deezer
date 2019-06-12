package com.siu.deezercomponentfirst.usecase

import com.siu.deezer.injection.data.FakeTasksRemoteDataSource
import com.siu.deezercomponentfirst.app.home.feed.pane.presenter.FeedPresenterInterface
import com.siu.deezercomponentfirst.app.home.feed.pane.usecase.FeedUseCase
import com.siu.deezercomponentfirst.app.home.feed.pane.viewmodel.FeedsViewState
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsRepository
import com.siu.deezercomponentfirst.tools.library.rxjava.TestImmediateSchedulerProvider
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UseCasePresenterUnitTest {

    @Mock
    private lateinit var mPresenter: FeedPresenterInterface

    private lateinit var mFeedPresenter: FeedUseCase

    @Before
    fun setupTasksViewModel() {
        MockitoAnnotations.initMocks(this)

        mFeedPresenter = FeedUseCase(
            FeedsRepository.getInstance(FakeTasksRemoteDataSource()),
            TestImmediateSchedulerProvider(),
            mPresenter
        )

    }

    @Test
    fun showFeed_FromPresenterThroughViewState() {
        mFeedPresenter.init()

        Mockito.verify(mPresenter).render(FeedsViewState(false, FakeTasksRemoteDataSource().getMockFeed()))

    }


}

