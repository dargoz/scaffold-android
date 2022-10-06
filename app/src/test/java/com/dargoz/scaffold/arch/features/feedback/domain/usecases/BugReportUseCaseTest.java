package com.dargoz.scaffold.arch.features.feedback.domain.usecases;

import static org.junit.Assert.assertEquals;

import com.dargoz.core.models.Result;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.subscribers.TestSubscriber;

public class BugReportUseCaseTest {
    private BugReportUseCase useCase;

    private final IssueEntity issueTestCase = new IssueEntity(
            0,
            "[BUG]",
            "error",
            "error",
            "tidak error",
            "",
            new ArrayList<>());

    private final IssueEntity issueResult = new IssueEntity(
            0,
            "[BUG]",
            "✔️ Actual\nerror❌ Expected\ntidak error",
            "",
            "",
            "2022-02-27T17:00:32.967Z",
            new ArrayList<>());

    @Before
    public void setup() {
        Repository repository = Mockito.mock(Repository.class);
        Mockito.doReturn(Flowable.just(new Result<>(200, "", issueResult)))
                .when(repository).createIssue(issueTestCase);
        useCase = new BugReportUseCase(repository);
    }

    @Test
    public void getDecoration() {
        String actual = useCase.getDescriptionDecoration(issueTestCase);
        String expected = "✔️ Actual\nerror\n\n❌ Expected\ntidak error";
        assertEquals(expected, actual);
    }

    @Test
    public void execute() {
        TestSubscriber<Result<IssueEntity>> testSubscriber = useCase.buildUseCase(issueTestCase).test();
        testSubscriber.assertSubscribed();
        Result<IssueEntity> expected = new Result<>(200, "", issueResult);
        testSubscriber.assertValue(expected);
    }


}