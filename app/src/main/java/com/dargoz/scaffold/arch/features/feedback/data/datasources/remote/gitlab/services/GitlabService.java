package com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.services;

import static com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.constants.GitlabConstant.PROJECT_ID;

import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.requests.IssueRequest;
import com.dargoz.scaffold.arch.features.feedback.data.datasources.remote.gitlab.responses.IssueResponse;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GitlabService {

    @POST("projects/" + PROJECT_ID + "/issues")
    Flowable<IssueResponse> createAnIssue(@Body IssueRequest issueRequest);

}
