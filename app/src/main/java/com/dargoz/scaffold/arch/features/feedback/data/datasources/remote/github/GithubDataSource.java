package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.github;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.github.services.GithubService;

import javax.inject.Inject;

public class GithubDataSource {
    private final GithubService githubService;

    @Inject
    public GithubDataSource(GithubService githubService) {
        this.githubService = githubService;
    }
}
