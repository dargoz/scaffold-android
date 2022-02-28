package com.dargoz.scaffold.arch.features.feedback.domain.usecases;


import com.dargoz.scaffold.arch.core.models.Result;
import com.dargoz.scaffold.arch.core.usecase.RxUseCase;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class BugReportUseCase extends RxUseCase<Result<IssueEntity>, IssueEntity> {
    private final Repository repository;

    @Inject
    public BugReportUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }

    @Override
    public Flowable<Result<IssueEntity>> buildUseCase(IssueEntity issueEntity) {
        issueEntity.setTitle("# " + issueEntity.getTitle());
        issueEntity.setDescription(getDescriptionDecoration(issueEntity));
        List<String> labels = new ArrayList<>();
        labels.add("bug");
        issueEntity.setLabels(labels);
        return repository.createIssue(issueEntity);
    }

    String getDescriptionDecoration(IssueEntity issue) {
        return "✔️ Actual\n" + issue.getActual() + "❌ Expected\n" + issue.getExpected();
    }


}
