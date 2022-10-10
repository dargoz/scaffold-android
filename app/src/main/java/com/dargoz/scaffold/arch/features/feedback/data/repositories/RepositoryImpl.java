package com.dargoz.scaffold.arch.features.feedback.data.repositories;

import android.util.Log;

import com.dargoz.core.models.Result;
import com.dargoz.core.models.UiState;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.local.LocalDataSource;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.GitlabDataSource;
import com.dargoz.scaffold.arch.features.feedback.data.utils.DataMappers;
import com.dargoz.scaffold.arch.features.feedback.domain.entity.IssueEntity;
import com.dargoz.scaffold.arch.features.feedback.domain.repositories.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RepositoryImpl implements Repository {
    private final GitlabDataSource gitlabDataSource;
    private final LocalDataSource localDataSource;


    @Inject
    public RepositoryImpl(
            GitlabDataSource gitlabDataSource,
            LocalDataSource localDataSource) {
        this.gitlabDataSource = gitlabDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public Flowable<List<IssueEntity>> getSavedIssue(int id) {
        return localDataSource.getIssue(id).map(DataMappers::mapToIssueEntity);
    }

    @Override
    public Flowable<Result<IssueEntity>> createIssue(IssueEntity issue) {
        return gitlabDataSource.createIssue(DataMappers.mapToIssueRequest(issue)).map(
                issueResponse -> {
                    Log.d("DRG","issue response : " + issueResponse.toString());
                    return new Result<>(UiState.success, "Success", DataMappers.mapToIssueEntity(issueResponse));
                }
        );
    }

    @Override
    public Flowable<Result<String>> saveIssue(IssueEntity issue) {
        return localDataSource.insertIssue(DataMappers.mapToIssue(issue))
                .map(result -> new Result<>(UiState.success, "Success", result.toString()));
    }
}
