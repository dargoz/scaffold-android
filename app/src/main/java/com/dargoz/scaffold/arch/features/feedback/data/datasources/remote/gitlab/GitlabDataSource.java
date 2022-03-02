package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.requests.IssueRequest;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.responses.IssueResponse;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.services.GitlabService;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GitlabDataSource {
    private final GitlabService gitlabService;

    @Inject
    public GitlabDataSource(GitlabService gitlabService) {
        this.gitlabService = gitlabService;
    }

    public Flowable<IssueResponse> createIssue(IssueRequest issueRequest) {
        return gitlabService.createAnIssue(issueRequest);
    }
}
