package com.dargoz.scaffold.arch.features.feedback.domain.usecases;

import com.dargoz.core.usecase.RxUseCase;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetSubmitHistoryUseCase extends RxUseCase<List<IssueEntity>, Integer> {
    private final Repository repository;

    @Inject
    public GetSubmitHistoryUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<List<IssueEntity>> buildUseCase(Integer id) {
        return repository.getSavedIssue(id);
    }
}
