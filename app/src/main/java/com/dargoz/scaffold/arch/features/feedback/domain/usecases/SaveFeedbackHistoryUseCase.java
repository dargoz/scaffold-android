package com.dargoz.scaffold.arch.features.feedback.domain.usecases;

import android.os.Looper;

import com.dargoz.scaffold.arch.core.models.Result;
import com.dargoz.scaffold.arch.core.usecase.RxUseCase;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SaveFeedbackHistoryUseCase extends RxUseCase<Result<String>, IssueEntity> {
    private final Repository repository;

    @Inject
    public SaveFeedbackHistoryUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Scheduler getScheduler() {
        if(Looper.getMainLooper() == null) return Schedulers.io();
        return AndroidSchedulers.from(Looper.getMainLooper());
    }

    @Override
    public Flowable<Result<String>> buildUseCase(IssueEntity issueEntity) {
        return repository.saveIssue(issueEntity);
    }
}
