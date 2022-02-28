package com.dargoz.scaffold.arch.features.feedback.domain.repositories;

import com.dargoz.scaffold.arch.core.models.Result;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface Repository {

    Flowable<List<IssueEntity>> getSavedIssue(int id);

    Flowable<Result<IssueEntity>> createIssue(IssueEntity issue);

    Flowable<Result<String>> saveIssue(IssueEntity issue);

}
