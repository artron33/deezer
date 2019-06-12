package com.siu.deezer.injection;

import com.siu.deezercomponentfirst.data.net.response.Album;
import com.siu.deezercomponentfirst.data.net.response.Feed;
import com.siu.deezercomponentfirst.data.repository.FeedRepositoryNetwork;
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsRepository;
import com.siu.deezercomponentfirst.tools.library.rxjava.BaseSchedulerProvider;
import com.siu.deezercomponentfirst.tools.library.rxjava.SchedulerProvider;

import java.util.List;

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

    public static List<Album> getMockFeed() {
        return new Feed().getData();
    }

}
