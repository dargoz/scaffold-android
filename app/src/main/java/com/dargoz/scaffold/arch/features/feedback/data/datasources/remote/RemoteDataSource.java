package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.requests.IssueRequest;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.responses.IssueResponse;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.services.GitlabService;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RemoteDataSource {
    private final GitlabService gitlabService;

    @Inject
    public RemoteDataSource(GitlabService gitlabService) {
        this.gitlabService = gitlabService;
    }

    public Flowable<IssueResponse> createIssue(IssueRequest issueRequest) {
        return gitlabService.createAnIssue(issueRequest);
    }
}
