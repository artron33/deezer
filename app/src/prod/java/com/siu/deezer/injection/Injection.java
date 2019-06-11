package com.siu.deezer.injection;

import android.content.Context;
import androidx.annotation.NonNull;
import com.siu.deezercomponentfirst.data.repository.FeedRepositoryNetwork;
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsRepository;
import com.siu.deezercomponentfirst.tools.library.rxjava.BaseSchedulerProvider;
import com.siu.deezercomponentfirst.tools.library.rxjava.SchedulerProvider;

public class Injection {

    /**
     * We will need the context,
     * To test Room !
     *
     * @return
     */
    public static FeedsRepository provideFeedsRepository() {
        return FeedsRepository.Companion.getInstance(new FeedRepositoryNetwork());
//todo: impleDataBase                FeedsLocalDataSource.getInstance(ToDoDatabase.Companion.getInstance(context).taskDao()));
    }

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
