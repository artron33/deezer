package com.siu.deezer.injection;

import com.siu.deezer.injection.data.FakeTasksRemoteDataSource;
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsDataSource;
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsRepository;
import com.siu.deezercomponentfirst.tools.library.rxjava.BaseSchedulerProvider;
import com.siu.deezercomponentfirst.tools.library.rxjava.SchedulerProvider;

/**
 * Enables injection of production implementations for
 * {@link FeedsDataSource} at compile time.
 */

public class Injection {

    public static FeedsRepository provideFeedsRepository() {
        return FeedsRepository.Companion.getInstance(new FakeTasksRemoteDataSource());
    }

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
