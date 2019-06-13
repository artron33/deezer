package com.siu.deezercomponentfirst.domain;


import android.content.Context;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import com.siu.deezer.injection.Injection;
import com.siu.deezercomponentfirst.data.net.response.Album;
import com.siu.deezercomponentfirst.domain.repository.feed.FeedsRepository;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Use:
 *     B U I L D    V A R I A N T
 *
 *     - To start with mock     data
 *     - To start with network  data //Returned picture's url changes 1 time / 2, so network test are not reliable 100%
 *     - Use MOCK build please
 *
 **/
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestRepositoryWith_variant {

    private FeedsRepository mRepository;

    private static List<Album> mFeedFromVariant;
    @Before
    public void setup() throws IOException {
        FeedsRepository.Companion.destroyInstance();

        final Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        mRepository = Injection.provideFeedsRepository();
        mFeedFromVariant = Injection.getMockFeed();

    }

    @Test
    public void testPreConditions() {
        assertNotNull(mRepository);
    }

    @Test
    public void getFeed_retrievesFeed() throws IOException {
        // Then the task can be retrieved from the persistent repository
        TestObserver<List<Album>> testObserver = new TestObserver<>();
        mRepository.getFeed("2529").subscribeWith(testObserver);

        testObserver.assertValue(val ->
                val.equals(mFeedFromVariant)
        );

    }



}
