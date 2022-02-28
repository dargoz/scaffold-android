package com.dargoz.scaffold.arch.features.feedback.domain.usecases;

import static org.junit.Assert.*;

import android.os.Looper;

import com.dargoz.scaffold.arch.core.models.Result;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;

public class SaveFeedbackHistoryUseCaseTest {
    private SaveFeedbackHistoryUseCase useCase;
    private MockedStatic<Looper> looperMockedStatic;
    private final IssueEntity issueResult = new IssueEntity(
            "[BUG]",
            "✔️ Actual\nerror❌ Expected\ntidak error",
            "",
            "",
            "2022-02-27T17:00:32.967Z",
            new ArrayList<>());

    @Before
    public void setUp() {
        looperMockedStatic = Mockito.mockStatic(Looper.class);
        Repository repository = Mockito.mock(Repository.class);
        Mockito.doReturn(Flowable
                .just(new Result<>(200, "success", issueResult.toString())))
                .when(repository).saveIssue(issueResult);
        useCase = new SaveFeedbackHistoryUseCase(repository);
    }

    @Test
    public void getScheduler() {
        assertNotNull(useCase.getScheduler());
        assertEquals(Schedulers.io(), useCase.getScheduler());
    }

    @Test
    public void buildUseCase() {
        TestSubscriber<Result<String>> testSubscriber = useCase.buildUseCase(issueResult).test();
        testSubscriber.assertSubscribed();
        testSubscriber.assertValue(new Result<>(200, "success", issueResult.toString()));
    }

    @After
    public void finish() {
        looperMockedStatic.close();
    }
}