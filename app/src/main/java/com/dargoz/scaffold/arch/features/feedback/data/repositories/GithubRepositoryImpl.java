package com.dargoz.scaffold.arch.features.feedback.data.repositories;

import com.dargoz.scaffold.arch.core.models.Result;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.local.LocalDataSource;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.github.GithubDataSource;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GithubRepositoryImpl implements Repository {
    private final GithubDataSource githubDataSource;
    private final LocalDataSource localDataSource;

    @Inject
    public GithubRepositoryImpl(GithubDataSource githubDataSource,
                                LocalDataSource localDataSource) {
        this.githubDataSource = githubDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Flowable<List<IssueEntity>> getSavedIssue(int id) {
        return null;
    }

    @Override
    public Flowable<Result<IssueEntity>> createIssue(IssueEntity issue) {
        return null;
    }

    @Override
    public Flowable<Result<String>> saveIssue(IssueEntity issue) {
        return null;
    }
}
