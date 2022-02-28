package com.dargoz.scaffold.arch.features.feedback.domain.usecases;

import static org.junit.Assert.*;

import android.os.Looper;

import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;


public class GetSubmitHistoryUseCaseTest {
    private GetSubmitHistoryUseCase useCase;
    private MockedStatic<Looper> looperMockedStatic;
    private final List<IssueEntity> issueEntities = new ArrayList<>();

    @Before
    public void setUp() {
        looperMockedStatic = Mockito.mockStatic(Looper.class);
        Repository repository = Mockito.mock(Repository.class);
        Mockito.doReturn(Flowable.just(issueEntities)).when(repository).getSavedIssue(0);
        useCase = new GetSubmitHistoryUseCase(repository);
    }

    @Test
    public void getScheduler() {
        assertNotNull(useCase.getScheduler());
        assertEquals(Schedulers.io(), useCase.getScheduler());
    }

    @Test
    public void buildUseCase() {
        TestSubscriber<List<IssueEntity>> testSubscriber = useCase.buildUseCase(0).test();
        testSubscriber.assertSubscribed();
    }

    @After
    public void finish() {
        looperMockedStatic.close();
    }
}